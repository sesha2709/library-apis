package com.fep.micro.libraryapis.libraryapis.publisher;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public ResponseEntity<?> getPublisher(@PathVariable Integer publisherId) throws LibraryResourceNotFoundException {

		return new ResponseEntity<>(publisherService.getPublisher(publisherId), HttpStatus.OK);

	}

	@PutMapping(path = "/{publisherId}")
	public ResponseEntity<?> updatePublisher(@PathVariable Integer publisherId, @Valid @RequestBody Publisher publisher)
			throws LibraryResourceNotFoundException {

		publisher.setPublisherId(publisherId);
		publisherService.updatePublisher(publisher);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addPublisher(@Valid @RequestBody Publisher publisher)
			throws LibraryResourceAlreadyExistsException {

		return new ResponseEntity<>(publisherService.addPublisher(publisher), HttpStatus.CREATED);

	}

	@DeleteMapping(path = "/{publisherId}")
	public ResponseEntity<?> deletePublisher(@PathVariable Integer publisherId)
			throws LibraryResourceNotFoundException {

		publisherService.deletePublisher(publisherId);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}
