package com.jobhunter24.UserDataManagementAPI.api.exception;

public class DuplicateTechnologyException extends RuntimeException {
    public DuplicateTechnologyException(String message) {
        super(message);
    }
}
