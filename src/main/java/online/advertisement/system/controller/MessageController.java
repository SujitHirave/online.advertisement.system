package online.advertisement.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.Category;
import online.advertisement.system.model.Message;
import online.advertisement.system.service.CategoryService;
import online.advertisement.system.service.MessageService;


@RestController
public class MessageController {
	private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService service;
	
	@PostMapping("/sendMessage")
	public Message sendMsg (Message smsg ) {
		LOG.info("send message");
		return service.sendMessage(smsg);
	}
}