package com.fep.micro.libraryapis.libraryapis.publisher;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fep.micro.libraryapis.libraryapis.exception.LibraryResourceAlreadyExistsException;

@Service
public class PublisherService {

	private PublisherRepositry publisherRespository;

	public PublisherService(PublisherRepositry publisherRespository) {

		this.publisherRespository = publisherRespository;
	}

	public Publisher addPublisher(Publisher publisherTobeAdded) throws LibraryResourceAlreadyExistsException {
		
		PublisherEntity publisherEntity = new PublisherEntity(

				publisherTobeAdded.getName(), publisherTobeAdded.getEmailId(), publisherTobeAdded.getPhoneNumber()

		);

		PublisherEntity addedPublisher = null;

		try {
			addedPublisher = publisherRespository.save(publisherEntity);
		} catch (DataIntegrityViolationException e) {
			
			throw new LibraryResourceAlreadyExistsException("Publisher Already Exists");
		}

		publisherTobeAdded.setPublisherId(addedPublisher.getPublisherId());
		
		return publisherTobeAdded;
	}

}
