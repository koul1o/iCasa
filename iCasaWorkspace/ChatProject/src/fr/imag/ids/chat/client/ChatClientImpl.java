/**
 * 
 */
package fr.imag.ids.chat.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import fr.imag.ids.chat.server.ChatService;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient {

	private static ChatService service = null;
	private static ChatClient client = null;
	private static String user;
	private static String HOST_NAME = "localhost";
	private static String SERVICE_NAME = "ChatService";

	ChatClientImpl(String user) throws RemoteException, NotBoundException
	{
		Registry registry = LocateRegistry.getRegistry(HOST_NAME);
		service = (ChatService) registry.lookup(SERVICE_NAME);
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.client.ChatClient#connect()
	 */
	@Override
	public void connect() throws RemoteException, NotBoundException {

		service.addClient(this);
	}

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.client.ChatClient#disconnect()
	 */
	@Override
	public void disconnect() throws RemoteException {
		service.removeClient(this);
		service=null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Welcome to the Chat System");
		System.out.println("Please enter your username: ");
		Scanner input = new Scanner(System.in);
		user = input.nextLine();
		try {
			client = new ChatClientImpl(user);
			client.connect();
			System.out.println(client.getName()+": You are now connected to the chat system");
			System.out.println(client.getName()+": Please enter your message..\n");
			input = new Scanner(System.in);
			service.sendMessage(client, input.nextLine());
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

	@Override
	public String getName() throws RemoteException {
		return user;
	}

	@Override
	public void sendMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}

}
