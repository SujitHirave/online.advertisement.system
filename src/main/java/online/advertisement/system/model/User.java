package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_adv") // user, administrator
public class User {

	@Id
	private int userid;
	@Column
	private String username;
	@Column
	private String address;
	@Column
	private long contactno;
	@Column
	private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userid, String username, String address,long contactno, String email) {
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

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
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
