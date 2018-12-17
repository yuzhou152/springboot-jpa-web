package com.zgg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zgg.web.scheduler.mq.handler.Sender;

@RestController
@RequestMapping(value="test")
public class TestController {
	@Autowired
	private Sender sender;
	
	@RequestMapping(value="hello")
	private void hello() {
		sender.send();
	}
}
