package soa.insa.td7.MicroService.model;

public class commandes {
	private int id;
	private String name;
	private int amount;
	
	public commandes(int id, String name, int amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public commandes(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public commandes() {}
	
	//setter
	public void setId(int id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setAmount(int amount) {this.amount = amount;}
	
	//getter
	public int getId() {return this.id;}
	public String getName() {return this.name;}
	public int getAmount() {return this.amount;}
	
}
