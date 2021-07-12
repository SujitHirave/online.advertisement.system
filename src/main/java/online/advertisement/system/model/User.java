package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_adv") 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	@Column(name = "username", nullable = false, length = 20)
	private String username;
	@Column(name = "address", nullable = false, length = 20)
	private String address;
	@Column(name = "contactno", nullable = false, length = 20)
	private String contactno;
	@Column(name="email",nullable = false, unique = true, length = 45)
	private String email;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userid, String username, String address, String contactno, String email) {
		super();
		this.userid = userid;
		this.username = username;
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
		return "User [userid=" + userid + ", username=" + username + ", address=" + address + ", contactno=" + contactno
				+ ", email=" + email + "]";
	}

	

}