package com.freelancer.dao;

import java.util.List;

import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.Client;

public interface ClientDao {

	public Client getClientByUsername(String username) throws UserNotFound;

	public void createClient(Client client);

	public void removeClient(Client client);

	public void updateClient(Client client, String new_password);

	public List<Client> getAllClients();

}
