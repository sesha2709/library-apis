package com.fep.micro.libraryapis.libraryapis.publisher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fep.micro.libraryapis.libraryapis.exception.LibraryResourceAlreadyExistsException;
import com.fep.micro.libraryapis.libraryapis.exception.LibraryResourceNotFoundException;

@RestController
@RequestMapping(path = "/v1/publishers")
public class PublisherController {

	public PublisherController(PublisherService publisherService) {
		super();
		this.publisherService = publisherService;
	}

	private PublisherService publisherService;

	@GetMapping(path = "/{publisherId}")
	public ResponseEntity<?> getPublisher(@PathVariable Integer publisherId) {

		Publisher publisher = null;

		try {
			publisher = publisherService.getPublisher(publisherId);
		} catch (LibraryResourceNotFoundException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(publisher, HttpStatus.OK);

	}
	
	
	@PutMapping(path= "/{publisherId}")
	public ResponseEntity<?> updatePublisher(@PathVariable Integer publisherId,@RequestBody Publisher publisher){
					
		try {
			
			publisher.setPublisherId(publisherId);
			publisherService.updatePublisher(publisher);
		
		} catch (LibraryResourceNotFoundException e) {
			
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<?> addPublisher(@RequestBody Publisher publisher) {

		try {
			publisher = publisherService.addPublisher(publisher);

		} catch (LibraryResourceAlreadyExistsException e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(publisher, HttpStatus.CREATED);

	}

}
