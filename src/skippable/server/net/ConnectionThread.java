package skippable.server.net;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ConnectionThread extends Thread implements Closeable {

	private ServerSocket serverSocket;
	private boolean persist;
	private Set<SocketThread> socketThreads;
	
	public ConnectionThread(ServerSocket ss) {
		setName("ConnectionThread");
		persist = true;
		serverSocket = ss;
		socketThreads = new HashSet<SocketThread>();
	}
	
	@Override
	public void run() {
		while(persist) {
			try {
				Socket s = serverSocket.accept();
				SocketThread thread = new SocketThread(s);
				socketThreads.add(thread);
				thread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void close() {
		persist = false;
		for (SocketThread st : socketThreads) {
			st.close();
		}
	}
	
}
