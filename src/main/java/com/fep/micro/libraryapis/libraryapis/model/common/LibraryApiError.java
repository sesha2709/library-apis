package com.fep.micro.libraryapis.libraryapis.model.common;

public class LibraryApiError {



    private String errorMessage;

    public LibraryApiError(){

    }

    public LibraryApiError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "LibraryApiError [errorMessage=" + errorMessage + "]";
    }

    
}