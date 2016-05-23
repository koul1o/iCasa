/**
 * 
 */
package fr.imag.ids.chat.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import fr.imag.ids.chat.client.ChatClient;

public interface ChatService extends Remote
{
	/**
	 * Add new client
	 * @param client
	 * @throws RemoteException
	 */
	public void addClient(ChatClient client) throws RemoteException;
	
	/**
	 * Remove new client
	 * @param client
	 * @throws RemoteException
	 */
	public void removeClient(ChatClient client) throws RemoteException;
	
	/**
	 * Send message to client
	 * @param client
	 * @param msg
	 * @throws RemoteException
	 */
	public void sendMessage(ChatClient client,String msg) throws RemoteException;
	
	/***
	 * Lists the registered clients
	 * @return 
	 * @throws RemoteException
	 */
	public List<ChatClient> listClients() throws RemoteException;
}