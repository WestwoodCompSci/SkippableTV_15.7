package skippable.server.encryption;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

//TODO: replace these with apache commons, I am currectly repressing an access restriction error in project settings on it
import sun.misc.BASE64Decoder; // Basically you should never use anything that starts with sun.misc
import sun.misc.BASE64Encoder; // org.apache commons libraries are external JAR files that I will use for this later 

public class AES {
	
	/**
	 * AES Encryption Class as of 4/17/14
	 * 
	 * Basically works like this: Hash(SALT+PASSPHRASE) ==AES-Algorithm==> ENCRYPTED_MESSAGE
	 * 
	 * EXAMPLE USAGE (feel free to copy and paste into backend, or read the rest of the comments for more detailed usage):
	 >	AES aes = new AES( password, AES.generateSalt() );
	 >	String message = "hello"; 
	 >	String encrypted = aes.encrypt("hello");
	 >	String decrypted = aes.decrypt(encrypted);
	 >  System.out.println(message + " =>\n" + encrypted + " =>\n" + decrypted);
	 * 
	 */
	
	//For generating secure and random salts
	private static final Random SecureRandomGenerator = new SecureRandom();
	
	//Use of this salt is not secure, ONLY USE FOR TESTING REASONS! 
	//Also note, generated salts are larger than this (16 bits instead of 8)
	private static final byte[] DEFAULTSALT = { 
		(byte) 0xA9, // Really this is arbitrary
        (byte) 0x9B, // Really this is arbitrary
        (byte) 0xC8, // Really this is arbitrary
        (byte) 0x32, // Really this is arbitrary
        (byte) 0x56, // Really this is arbitrary
        (byte) 0x35, // Really this is arbitrary
        (byte) 0xE3, // Really this is arbitrary
        (byte) 0x03  // Really this is arbitrary
    };
	
	//Amount of iterations used in encryption, 65536 is very secure
    private static final int ITERATION_COUNT = 65536;
    
    //Encryption Key Length currently 128
    //128 bit, 256 would be better, but requires modifying how JAVA policy (default cryptography strength is explicitly limited)
    //Basically, to use a large key, you must download and enable "unlimited strength jurisdiction policy"
    //Because this download can not be packaged with the JAR, it's use would break client compatibility
    //Other alternative options include Bouncy Castle, and Spring 3rd party Cryptography tools
    private static final int KEY_LENGTH = 128;
    
    
    //For encryption and decryption, initialized in the constructor
    private Cipher encryptionCipher;
    private Cipher decryptionCipher;
    
    //Flipped if the constructor fails
    public boolean ErrorState = false;
    
    //Please use this method, and be sure to save the salt in a database for future use
    //Appropriate salts can be produced with a call to AES.generateSalt
    public AES(String keyPhrase, byte[] salt){
    	try {
    		// PBKDF2WithHmacSHA1 is an algorithm for generating keys
    		String algorithm = "PBKDF2WithHmacSHA1";
    		// Initialize a SecretKeyFactor to make encryption keys
    		SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
    		// Key settings, and content base
			KeySpec keySettings = new PBEKeySpec(keyPhrase.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
			// A temporary key with specified settings
			SecretKey __= factory.generateSecret(keySettings);
			// AES based secret key generated from the encoding of the temporary one 
			SecretKey secret = new SecretKeySpec(__.getEncoded(), "AES");
			//Instantiate encryptionCipher with AES algorithm
			encryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			//Initialize the encryption cipher, and provide it the secret key
			encryptionCipher.init(Cipher.ENCRYPT_MODE, secret);
			//Instantiate encryptionCipher with AES algorithm
			decryptionCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			//Used initialization vector used for decrypting AES, ensures that it is direct reverse of the encryption cipher
			byte[] initializationVector = encryptionCipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
			//Initialize the encryption decipher, and provide it the initialization vector to ensure it reverses the encryptor
			decryptionCipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(initializationVector));
			
    	} catch (Exception e) {
    		//Darn it
			ErrorState = true;
		}
    }
    
    //Not secure against Rainbow Tables and Dictionary Attacks (similar to WEP)
    //Made worse since this is open source, and so default salt can be viewed on GITHUB
    public AES(String keyPhrase){
    	this(keyPhrase, DEFAULTSALT);
    }

	//n bit additional salt for securing against rainbow tables
    //Value of bytes that I recommend,  recommended minimum 8, recommended: 16, recommended maximum: 32 (MUST BE POWER OF TWO, don't make it too big, DO NOT MAKE IT TOO SMALL)
	public static byte[] generateSalt(int bytes) {
		/**
	     * What This Is:
	     * Salts are like a second password that makes it harder to crack with rainbow tables
	     * Pass phrases are hashed after being concatenated with a randomly generated salt
	     * This makes passwords longer (thus harder to guess), and less vulnerable to rainbow tables and dictionary attacks when common passwords are chosen 
	     */
		// Create an empty array of eight bytes
		byte[] saltBits = new byte[bytes];
		// Fills the array with random bytes (does not return anything), so can not concactenated with next line
	    SecureRandomGenerator.nextBytes(saltBits);
	    // Returns the filled array
	    return saltBits;
	  }
	//If unsure how many bytes to use, use this
	public static byte[] generateSalt() {
		//Generates a new salt with a default 16 bit size, which is quite large, but not excessive 
		return generateSalt(16); 
	}

	//Encrypt message with current established salt
	public String encrypt(String message) {
		try{
			//Convert plain message into raw bytes, UTF8 is standard character set
			byte[] messageBytes = message.getBytes("UTF8");
			//Use AES algorithm to encrypt the message as bytes
		    byte[] encrypted = encryptionCipher.doFinal(messageBytes);
		    //Take the encrypted bytes and rebuild a string from them
		    //TODO: This should be done with apache commons library!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		    return new BASE64Encoder().encode(encrypted);
		}
		catch(Exception e){
			//Darn it!
			ErrorState = true;
		}
		return null;//Only reaches this point in an error state
	}
	
	//Decrypt message with current salt
	public String decrypt(String secretMessage) {
		try{
			//Convert secret message into raw bytes
			//TODO: this should be done with apache commons library!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			byte[] messageBytes = new BASE64Decoder().decodeBuffer(secretMessage);
			//Decrypt bytes with AES
			byte[] decrypted = decryptionCipher.doFinal(messageBytes);
	        //Code the bytes into a string, and return that string
	        return new String(decrypted, "UTF8"); 
		}
		catch(Exception e){
			//Darn it!
			ErrorState = true;
			return null;
		}
	}
}
