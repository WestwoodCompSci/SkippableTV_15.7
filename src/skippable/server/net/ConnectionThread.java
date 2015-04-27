package skippable.server.net;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Set;

import skippable.common.net.SocketThread;

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
				Socket s = null;
				try {
					s = serverSocket.accept();
				} catch (SocketTimeoutException ste) {
					continue;
				}
				SocketThread thread = new SocketThread(s, new ServerInputHandler());
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
