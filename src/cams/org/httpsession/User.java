package cams.org.httpsession;

public class User {
	private String name, lastname;
	
	public User () {}
	
	public User (String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setLastname (String lastname) {
		this.lastname = lastname;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
}
