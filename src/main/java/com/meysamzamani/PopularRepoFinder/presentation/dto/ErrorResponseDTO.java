package com.meysamzamani.PopularRepoFinder.presentation.dto;

import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {

    private HttpStatus status;
    private String message;

    public ErrorResponseDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}