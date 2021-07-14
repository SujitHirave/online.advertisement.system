package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "advertise_adv")
public class Advertise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int advid;
	@Column
	private String advertisetitle;
	@Column(name = "price", nullable = false, length = 20)
	private double price;
	@Column(name = "description", nullable = false, length = 20)
	private String description;
	@Column(name = "status", nullable = false, length = 20)
	private String status;

	@ManyToOne
	@JoinColumn(name = "catid")
	private Category category;

	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertise(int advid, String advertisetitle, double price, String description, String status,
			Category category) {
		super();
		this.advid = advid;
		this.advertisetitle = advertisetitle;
		this.price = price;
		this.description = description;
		this.status = status;
		this.category = category;
	}

	public int getAdvid() {
		return advid;
	}

	public void setAdvid(int advid) {
		this.advid = advid;
	}

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Advertise [advid=" + advid + ", advertisetitle=" + advertisetitle + ", price=" + price
				+ ", description=" + description + ", status=" + status + ", category=" + category + "]";
	}



}
