/**
 * 
 */
package fr.imag.ids.chat.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import fr.imag.ids.chat.client.ChatClient;

/**
 * @author ajayk
 *
 */
public class ChatServiceImpl implements ChatService {

	public String serviceName;
	List<ChatClient> clients = new ArrayList<ChatClient>();
	
	public ChatServiceImpl(String serviceName) {
		this.serviceName = serviceName;
	}

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.service.ChatService#addClient(fr.imag.ids.chat.client.ChatClient)
	 */
	@Override
	public void addClient(ChatClient client) throws RemoteException {
		for(ChatClient name: clients)
			if(name.getName().equals(client.getName()))
				throw new RemoteException("User name already exists!");
		clients.add(client);
	}

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.service.ChatService#removeClient(fr.imag.ids.chat.client.ChatClient)
	 */
	@Override
	public void removeClient(ChatClient client) throws RemoteException {
		clients.remove(client);
	}

	/* (non-Javadoc)
	 * @see fr.imag.ids.chat.service.ChatService#sendMessage(fr.imag.ids.chat.client.ChatClient, java.lang.String)
	 */
	@Override
	public void sendMessage(ChatClient client, String msg) throws RemoteException {
		if(clients.contains(client)) 
		{
			for(int i=0;i<clients.size();i++)
			{
				String user=client.getName();
				((ChatClient)clients.get(i)).sendMessage(user+" : "+msg);
			}
		}
	}

	@Override
	public List<ChatClient> listClients() throws RemoteException {
		return clients;
	}
}
