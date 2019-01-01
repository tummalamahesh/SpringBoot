package com.sabre.courseapi.topics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	

	public SampleController() {
		super();
		System.out.println("SampleController constructor-----------------");
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
}
