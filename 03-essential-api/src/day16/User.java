package day16;

public class User {

	private String name;
	private String role;
	
	public User() {
		
	}
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean IsStaff() {
		return this.role.equals("staff");
	}
	
	
}
