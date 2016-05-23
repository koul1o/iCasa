/**
 * 
 */
package fr.imag.ids.chat.client;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient extends Remote {
	
	/**
	 * getName
	 * @throws RemoteException
	 */
	public String getName() throws RemoteException;
	
	/**
	 * sendMessage
	 * @param msg
	 * @throws RemoteException
	 */
	public void sendMessage(String msg) throws RemoteException;
	
	/**
	 * connect to server
	 * @throws RemoteException
	 * @throws NotBoundException 
	 */
	public void connect() throws RemoteException, NotBoundException;
	
	/**
	 * disconnect from server
	 * @throws RemoteException
	 */
	public void disconnect() throws RemoteException;

}
