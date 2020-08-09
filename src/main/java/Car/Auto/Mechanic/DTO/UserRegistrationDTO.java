package Car.Auto.Mechanic.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationDTO {

	@NotEmpty(message = "May not be empty")
	private String name;

	@NotEmpty(message = "May not be empty")
	private String surname;

	@NotEmpty(message = "May not be empty")
	private String phone;

	@Email
	@NotEmpty(message = "May not be empty")
	private String email;

	@NotEmpty(message = "May not be empty")
	private String password;

	public UserRegistrationDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}