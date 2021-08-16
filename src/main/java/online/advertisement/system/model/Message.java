package online.advertisement.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "message_adv")
public class Message {

	@Id
	@Column(name = "msgid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "msgid_generator")
	@SequenceGenerator(name = "msgid_generator", initialValue = 301, allocationSize = 1, sequenceName = "msgId_seq")
	private int msgid;

	@OneToOne
	@JoinColumn(name = "advid",nullable = true)
	private Advertise advertise;
	
	

	@OneToOne
	@JoinColumn(name = "userid" ,nullable = true)
	private AppUser appUser;

	@Column(name = "textMessage", nullable = false, length = 60)
	private String textMessage;

	public Message() {
		super();
	}
	
	

	public Message(Advertise advertise, String textMessage) {
		super();
		this.advertise = advertise;
		this.textMessage = textMessage;
	}



	public Message(int msgid, Advertise advertise, String textMessage) {
		super();
		this.msgid = msgid;
		this.advertise = advertise;
		this.textMessage = textMessage;
	}



	public Message(int msgid, Advertise advertise, AppUser appUser, String textMessage) {
		super();
		this.msgid = msgid;
		this.advertise = advertise;
		this.appUser = appUser;
		this.textMessage = textMessage;
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

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", advertise=" + advertise + ", appUser=" + appUser + ", textMessage="
				+ textMessage + "]";
	}

}