/**
 * 
 */
package fr.imag.ids.chat.server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author ajayk
 *
 */
public class ChatServerImpl implements ChatServer {

	public static String SERVER_NAME = "localhost";
	public static String SERVICE_NAME = "ChatService";
	public static int PORT = 1099;
	Registry registry = null;
	ChatServiceImpl service = null;

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.server.ChatServer#start()
	 */
	@Override
	public void start() throws RemoteException {
		try {	
			registry = java.rmi.registry.LocateRegistry.createRegistry(PORT);

			service = new ChatServiceImpl("ChatService");
			ChatService chatServiceStub = (ChatService) UnicastRemoteObject.exportObject(service,0);

			registry.bind("ChatService", chatServiceStub);

			System.out.println("Server: "+SERVICE_NAME+" - Started Successfully!");
		} catch(Exception e)
		{
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			throw new RemoteException();
		}
	}

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {

		ChatServer server = new ChatServerImpl();
		server.start();
		//server.stop();
	}

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.server.ChatServer#stop()
	 */
	@Override
	public void stop() throws RemoteException, NotBoundException {

		registry.unbind("ChatService");
		UnicastRemoteObject.unexportObject(service, true);
		System.out.println("Server: "+SERVICE_NAME+" - Stopped Successfully!");
	}
}
