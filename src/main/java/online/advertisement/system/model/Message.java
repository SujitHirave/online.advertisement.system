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
	
//	private int id; // messageId 
//	private int sellerId; 
//	private int buyerId;
//	private int advId;
//	private String messageText;
	
	@OneToOne
	@JoinColumn(name = "advid")
	private Advertise advertise;
	
	@OneToOne
	@JoinColumn(name = "userid")
	private AppUser appUser;
	
	@Column(name = "sellerId", length = 20)
	private int sellerId;
	
	@Column(name = "buyerId", length = 20)
	private int buyerId;
	
	@Column(name = "textMessage", nullable = false, length = 60)
	private String textMessage;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Message(int msgid, Advertise advertise, AppUser appUser, String textMessage) {
		super();
		this.msgid = msgid;
		this.advertise = advertise;
		this.appUser = appUser;
		this.textMessage = textMessage;
	}


	public Message(int msgid, Advertise advertise, AppUser appUser, int sellerId, int buyerId, String textMessage) {
		super();
		this.msgid = msgid;
		this.advertise = advertise;
		this.appUser = appUser;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.textMessage = textMessage;
	}

	public Message(Advertise advertise, int sellerId, int buyerId) {
		super();
		this.advertise = advertise;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
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

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", advertise=" + advertise + ", appUser=" + appUser + ", sellerId="
				+ sellerId + ", buyerId=" + buyerId + ", textMessage=" + textMessage + "]";
	}

	
}
