package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message_adv")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int msgid;
	
	@OneToOne
	@JoinColumn(name = "advid")
//	@JoinColumn(name = "advid", referencedColumnName = "msgid")
	private Advertise advertise;
	
	@Column(name = "seller", nullable = true, length = 20)
	private String seller;
	
	@Column(name = "buyer", nullable = false, length = 20)
	private String buyer;
	
	@Column(name = "message", nullable = false, length = 60)
	private String message;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int msgid, Advertise advertise, String seller, String buyer, String message) {
		super();
		this.msgid = msgid;
		this.advertise = advertise;
		this.seller = seller;
		this.buyer = buyer;
		this.message = message;
	}

	public int getMsgid() {
		return msgid;
	}

	public void setMsgid(int msgid) {
		this.msgid = msgid;
	}

	public Advertise getAdvertise() {
		return advertise;
	}

	public void setAdvertise(Advertise advertise) {
		this.advertise = advertise;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", advertise=" + advertise + ", seller=" + seller + ", buyer=" + buyer
				+ ", message=" + message + "]";
	}

	
	
	

}
