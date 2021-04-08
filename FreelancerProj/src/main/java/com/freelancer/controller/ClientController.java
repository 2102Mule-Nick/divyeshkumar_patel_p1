package com.freelancer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freelancer.dao.ClientDaoJDBCTemplate;
import com.freelancer.exception.UserNotFound;
import com.freelancer.pojo.Client;

@Controller
public class ClientController {

	private ClientDaoJDBCTemplate clientDaoJdbc;

	@Autowired
	public void setClientDaoJdbc(ClientDaoJDBCTemplate clientDaoJdbc) {
		this.clientDaoJdbc = clientDaoJdbc;
	}

	// Gets all the freelancers registered
	@GetMapping("/freelancer-clients/")
	@ResponseBody
	public List<Client> getClients() {
		return clientDaoJdbc.getAllClients();
	}

	//Retrieves client-info from the username	
	@GetMapping("/freelancer-clients/{username}")
	@ResponseBody
	public ResponseEntity<Client> getClient(@PathVariable("username") String username) {
		try {
			return ResponseEntity.ok(clientDaoJdbc.getClientByUsername(username));
		} catch (UserNotFound e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/freelancer-clients/new")
	@ResponseBody
	public ResponseEntity<String> createClient(@RequestBody Client client){
		clientDaoJdbc.createClient(client);
		return ResponseEntity.ok("New Client created");
				
	}
	
	@PutMapping("/freelancer-clients/update/{new_pass}")
	@ResponseBody
	public ResponseEntity<String> updateClPassword(@RequestBody Client client,@PathVariable("new_pass")String new_password){
		try {
			clientDaoJdbc.updateClient(client, new_password);
			return ResponseEntity.ok("Client Password updated");
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/freelancer-client/delete")
	@ResponseBody
	public void deleteClient(@RequestBody Client client) {
		clientDaoJdbc.removeClient(client);
	}
}
