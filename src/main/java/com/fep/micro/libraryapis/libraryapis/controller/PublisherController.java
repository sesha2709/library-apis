package com.fep.micro.libraryapis.libraryapis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fep.micro.libraryapis.libraryapis.domain.Publisher;

@RestController
@RequestMapping(path="/v1/publishers")
public class PublisherController {

	
	@GetMapping(path="/{publisherId}")
	public Publisher getPublisher(@PathVariable String publisherId) {
				
		return new Publisher(publisherId, "Prentice Hall Publishers", "rentice@gmail.com", "123-456-7890");
	}
	
	
	
	
}
