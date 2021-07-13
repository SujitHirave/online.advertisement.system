package online.advertisement.system.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "category_adv")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catid;
	@OneToMany(mappedBy="category")
	private List<Advertise> advertises;
	
	@Column(name = "catname", nullable = false, length = 20)
	private String catname;
	@Column(name = "catdescription", nullable = false, length = 20)
	private String catdescription;
	
	
	
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int catid, String catname, String catdescription) {
		super();
		this.catid = catid;
		this.catname = catname;
		this.catdescription = catdescription;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getCatdescription() {
		return catdescription;
	}

	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}

	@Override
	public String toString() {
		return "Category [catid=" + catid + ", catname=" + catname + ", catdescription=" + catdescription + "]";
	}

}
