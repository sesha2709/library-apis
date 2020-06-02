package com.fep.micro.libraryapis.libraryapis.publisher;


import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fep.micro.libraryapis.libraryapis.exception.LibraryResourceAlreadyExistsException;
import com.fep.micro.libraryapis.libraryapis.exception.LibraryResourceNotFoundException;

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

	public Publisher getPublisher(Integer publisherId) throws LibraryResourceNotFoundException {
		
		Optional<PublisherEntity>publisherEntity=publisherRespository.findById(publisherId);
		
		Publisher publisher= null;
		
		if(publisherEntity.isPresent()) {
			PublisherEntity pe = publisherEntity.get();
			
			publisher = createPubliser(pe);
			
		}else {
			throw new LibraryResourceNotFoundException("No Publisher found with the Id:"+publisherId);
		}
		
		return publisher;
		
	}

	private Publisher createPubliser(PublisherEntity pe) {
		
		return new Publisher(pe.getPublisherId(),pe.getName(),pe.getPhone_no(),pe.getEmail_id());
	}

}
