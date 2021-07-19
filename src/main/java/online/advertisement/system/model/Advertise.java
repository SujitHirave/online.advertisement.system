package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "advertise_adv")
public class Advertise {

	@Id
	@Column(name = "advid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "advid_generator")
	@SequenceGenerator(name = "advid_generator", initialValue = 201, allocationSize = 1, sequenceName = "advId_seq")
	private int advid;
	@OneToOne(mappedBy = "advertise")
	private Message message;

	@Column(name = "advertisetitle", length = 50)
	private String advertisetitle;

	@Column(name = "price", length = 10)
	private double price;

	@Column(name = "description", length = 40)
	private String description;

	@Column(name = "status", length = 10)
	private String status;

	@Column(name = "advownername", length = 20)
	private String advownername;

	@ManyToOne
	@JoinColumn(name = "catid")
	private Category category;

	public Advertise() {
		super();
	}
	

	public Advertise(String advertisetitle, double price, String description, Category category) {
		super();
		this.advertisetitle = advertisetitle;
		this.price = price;
		this.description = description;
		this.category = category;
	}
	
	


	public Advertise(int advid, String advertisetitle, double price, String description, String advownername,
			Category category) {
		super();
		this.advid = advid;
		this.advertisetitle = advertisetitle;
		this.price = price;
		this.description = description;
		this.advownername = advownername;
		this.category = category;
	}

//	public Advertise(String advertisetitle) {
//	super();
//	this.advertisetitle = advertisetitle;
//}
//
//	
//
//	public Advertise(String description) {
//		super();
//		this.description = description;
//	}


	public Advertise(int advid, Message message, String advertisetitle, double price, String description, String status,
			String advownername, Category category) {
		super();
		this.advid = advid;
		this.message = message;
		this.advertisetitle = advertisetitle;
		this.price = price;
		this.description = description;
		this.status = status;
		this.advownername = advownername;
		this.category = category;
	}

	public Advertise(int advid, Message message, String advertisetitle, double price, String description,
			String advownername, Category category) {
		super();
		this.advid = advid;
		this.message = message;
		this.advertisetitle = advertisetitle;
		this.price = price;
		this.description = description;
		this.advownername = advownername;
		this.category = category;
	}


	public Advertise(int advid, String status) {
		super();
		this.advid = advid;
		this.status = status;
	}

	public int getAdvid() {
		return advid;
	}

	public void setAdvid(int advid) {
		this.advid = advid;
	}

//	public Message getMessage() {
//		return message;
//	}
//
//	public void setMessage(Message message) {
//		this.message = message;
//	}

	public String getAdvertisetitle() {
		return advertisetitle;
	}

	public void setAdvertisetitle(String advertisetitle) {
		this.advertisetitle = advertisetitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdvownername() {
		return advownername;
	}

	public void setAdvownername(String advownername) {
		this.advownername = advownername;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Advertise [advid=" + advid + ", advertisetitle=" + advertisetitle + ", price=" + price
				+ ", description=" + description + ", status=" + status + ", advownername=" + advownername
				+ ", category=" + category + "]";
	}

}