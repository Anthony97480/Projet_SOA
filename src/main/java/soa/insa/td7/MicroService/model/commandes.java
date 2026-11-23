package soa.insa.td7.MicroService.model;

public class commandes {
	private int id;
	private String name;
	
	public commandes(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public commandes() {}
	
	//setter
	public void setId(int id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	
	//getter
	public int getId() {return this.id;}
	public String getName() {return this.name;}
	
}
