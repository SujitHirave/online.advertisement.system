package online.advertisement.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.service.MessageService;

@RestController
public class MessageController {
	private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService service;

// Buyer can send a message to the seller 
	@PostMapping("/buyer/sendMessage")
	public void sendMsg(int msgid, int userid, int advid, String text_message) {
		LOG.info("send message");
		service.sendMessage(msgid, userid, advid, text_message);
	}
}