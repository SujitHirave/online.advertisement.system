package online.advertisement.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.advertisement.system.model.Message;
import online.advertisement.system.repository.MessageRepository;

/**
 * 
 * service for Message functionalities
 *
 */

@Service
public class MessageService {

	private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private MessageRepository repository;

//	public void sendMessage(int msgid, int userid, int advid, String text_message) {
//		LOG.info("send message");
//		repository.inserteds(msgid, userid, advid, text_message);
//	}
	
	
	public Message sendMessage(Message msg) {
		LOG.info("send message");
		return repository.save(msg);
	}
}
