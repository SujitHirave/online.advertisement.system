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
	
	@Column
	private String senderUserName;
	
	@Column
	private String msg;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int msgid, Advertise advertise, String senderUserName, String msg) {
		super();
		this.msgid = msgid;
		this.advertise = advertise;
		this.senderUserName = senderUserName;
		this.msg = msg;
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

	public String getSenderUserName() {
		return senderUserName;
	}

	public void setSenderUserName(String senderUserName) {
		this.senderUserName = senderUserName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Message [msgid=" + msgid + ", advertise=" + advertise + ", senderUserName=" + senderUserName + ", msg="
				+ msg + "]";
	}
	
	
	

}
