package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_adv") 
public class AppUser {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userid_generator")
	@SequenceGenerator(name = "userid_generator", initialValue = 101, allocationSize = 1, sequenceName = "userId_seq")
	private int userid;
	
	@Column(name = "username", length = 10, unique = true)
	private String username;
	
	@Column(name = "password", length = 10)
	private String password;

	@Column
	private Role role;
	
	@Column(name = "firstName", length = 20)
	private String firstName;
	
	@Column(name = "lastName", length = 20)
	private String lastName;
	
	@OneToOne(mappedBy="appUser")
	private Message message;
	
//	@Column(name = "username", nullable = false, length = 20)
//	private String username;

	@Column(name = "address",  length = 40)
	private String address;
	
	@Column(name = "contactno", length = 10)
	private String contactno;
	
	@Column(name="email",nullable = false, unique = true, length = 30)
	private String email;

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AppUser(String username, String password, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public AppUser(int userid, String username, String password, Role role, String firstName, String lastName,
			Message message, String address, String contactno, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public Message getMessage() {
//		return message;
//	}
//
//	public void setMessage(Message message) {
//		this.message = message;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AppUser [userid=" + userid + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", contactno="
				+ contactno + ", email=" + email + "]";
	}
	
	
}