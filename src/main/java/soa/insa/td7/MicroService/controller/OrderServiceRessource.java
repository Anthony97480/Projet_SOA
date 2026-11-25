package soa.insa.td7.MicroService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import soa.insa.td7.MicroService.model.Client;
import soa.insa.td7.MicroService.model.OrderService;
import soa.insa.td7.MicroService.service.clientService;

@RestController
@RequestMapping("/Order")
public class OrderServiceRessource {
	String db_URL = "jdbc:sqlite:e_commerce.db";
	clientService clt_service = new clientService(db_URL);
	//OrderService os = new OrderService();
	
	@GetMapping("client/{id}")
	public Client infosClient(@PathVariable int id) {
		Client client = clt_service.getClientByID(id);
		return client;
	}
	
	@PostMapping("client/add")
	public String addClient(@RequestParam String lastname, @RequestParam String firstname) {
		Client client = new Client(lastname, firstname);
		clt_service.AddClient(client);
		return "Client: " + lastname + " " + firstname + " added !";
	}
	
	@PutMapping("client/{id}/rename")
	public String updateClient(@PathVariable int id, @RequestParam String lastname, @RequestParam String firstname) {
		clt_service.RenameClient(id, lastname, firstname);
		return "Client id:" + id + " renamed into: " + lastname + " " + firstname;
	}
}
