package online.advertisement.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import jdk.internal.org.jline.utils.Log;
import online.advertisement.system.model.Message;
import online.advertisement.system.repository.CategoryRepository;
import online.advertisement.system.repository.MessageRepository;

@Service
public class MessageService {

	private static final Logger LOG = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private MessageRepository repository;
	
	public Message sendMessage(Message smsg) {
		LOG.info("send message");
		return repository.save(smsg);
	}

}
