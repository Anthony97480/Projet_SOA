package soa.insa.td7.MicroService.controller;

import soa.insa.td7.MicroService.model.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Order")
public class OrderServiceRessource {
	OrderService os = new OrderService();
	
	@RequestMapping("/client")
	public class ClientRessource {
		
		@GetMapping("/{id}")
		public Client infosClient(@PathVariable int id) {
			Client client = new Client(id, "Rosa", "Parks");
			return client;
		}
		
		@PostMapping("/add")
		public String addClient(@RequestParam String lastname, @RequestParam String firstname) {
			Client client = new Client();
			client.setLastName(lastname);
			client.setFirstName(firstname);
			
			return os.AddClient(client);
		}
		
		@PutMapping("/update")
		public String updateClient(@RequestParam String Newlastname, @RequestParam String Newfirstname) {
			return "Pas fait";
		}
	}
	
	@RequestMapping("/commande")
	public class CommandeRessource {
		
	}
}
