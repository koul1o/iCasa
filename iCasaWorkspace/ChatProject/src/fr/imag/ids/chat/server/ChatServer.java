/**
 * 
 */
package fr.imag.ids.chat.server;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatServer extends Remote {
	/**
	 * Starts the chat server
	 * @throws RemoteException
	 */
	void start() throws RemoteException;
	
	/**
	 * Stops the chat server
	 * @throws RemoteException
	 * @throws NotBoundException 
	 */
	void stop() throws RemoteException, NotBoundException;
}
