package soa.insa.td7.MicroService.model;

public class Client {
	private int id;
	private String firstname;
	private String lastname;
	
	public Client(int id, String lastname, String firstname) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Client(String lastname, String firstname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Client() {}
	
	//setter
	public void setId(int id) {this.id = id;}
	public void setLastName(String lastname) {this.lastname = lastname;}
	public void setFirstName(String firstname) {this.firstname = firstname;}
	
	//getter
	public int getId() {return this.id;}
	public String getLastName() {return this.lastname;}
	public String getFirstName() {return this.firstname;}
	
	
}
