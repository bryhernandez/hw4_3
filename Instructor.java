package hw4;

public class Instructor{
	
	private int ID;
	private String name;
	private String email;
	private String phone;
	
	public Instructor(int ID, String name, String email, String phone) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	
	@Override
	public String toString() {
		return "Instructor [ID=" + ID + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
