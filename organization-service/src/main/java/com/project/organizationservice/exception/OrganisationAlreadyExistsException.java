package com.project.organizationservice.exception;

public class OrganisationAlreadyExistsException extends RuntimeException{
    public OrganisationAlreadyExistsException(String message) {
        super(message);
    }
}
