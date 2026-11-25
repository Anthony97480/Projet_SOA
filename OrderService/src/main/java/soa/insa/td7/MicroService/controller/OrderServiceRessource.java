package soa.insa.td7.MicroService.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soa.insa.td7.MicroService.model.Client;
import soa.insa.td7.MicroService.handler.clientHandler;

@RestController
@RequestMapping("/Order")
public class OrderServiceRessource {
	String db_URL = "jdbc:sqlite:e_commerce.db";
	clientHandler clt_handler = new clientHandler(db_URL);
	
	@GetMapping("client/{id}")
	public Client infosClient(@PathVariable int id) {
		Client client = clt_handler.getClientByID(id);
		return client;
	}
	
	@PostMapping("client/add")
	public String addClient(@RequestParam String lastname, @RequestParam String firstname) {
		Client client = new Client(lastname, firstname);
		clt_handler.AddClient(client);
		return "Client: " + lastname + " " + firstname + " added !";
	}
	
	@PutMapping("client/{id}/rename")
	public String updateClient(@PathVariable int id, @RequestParam String lastname, @RequestParam String firstname) {
		clt_handler.RenameClient(id, lastname, firstname);
		return "Client id:" + id + " renamed into: " + lastname + " " + firstname;
	}
	
	@DeleteMapping("client/del/{id}")
	public String delClient(@PathVariable int id) {
		Client client = clt_handler.getClientByID(id);
		clt_handler.DeleteClientByID(id);
		return "Client: " + client.getFirstName() + " " + client.getLastName() + " deleted !";
	}
}
