package com.fep.micro.libraryapis.libraryapis.exception;

import com.fep.micro.libraryapis.libraryapis.model.common.LibraryApiError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LibraryResourceNotFoundException.class)
    public final ResponseEntity<LibraryApiError> handleLibraryResourceNotFoundException(
            LibraryResourceNotFoundException e, WebRequest webrequest) {

        return new ResponseEntity<>(new LibraryApiError(e.getMessage()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(LibraryResourceAlreadyExistsException.class)
    public final ResponseEntity<LibraryApiError> handleLibraryResourceAlreadyExistException(
            LibraryResourceAlreadyExistsException e, WebRequest webrequest) {

        return new ResponseEntity<>(new LibraryApiError(e.getMessage()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<LibraryApiError> handleLibraryAllExceptions(Exception e, WebRequest webrequest) {

        return new ResponseEntity<>(new LibraryApiError(e.getMessage()), HttpStatus.BAD_REQUEST);

    }

}