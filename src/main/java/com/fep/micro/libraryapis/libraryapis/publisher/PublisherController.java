package com.fep.micro.libraryapis.libraryapis.publisher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fep.micro.libraryapis.libraryapis.exception.LibraryResourceAlreadyExistsException;

@RestController
@RequestMapping(path = "/v1/publishers")
public class PublisherController {

	public PublisherController(PublisherService publisherService) {
		super();
		this.publisherService = publisherService;
	}

	private PublisherService publisherService;

	@GetMapping(path = "/{publisherId}")
	public Publisher getPublisher(@PathVariable Integer publisherId) {

		return new Publisher(publisherId, "Prentice Hall Publishers", "rentice@gmail.com", "123-456-7891");
	}

	@PostMapping
	public ResponseEntity<?> addPublisher(@RequestBody Publisher publisher) {

		try {
			publisher = publisherService.addPublisher(publisher);

		} catch (LibraryResourceAlreadyExistsException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(publisher,HttpStatus.CREATED);

	}

}
