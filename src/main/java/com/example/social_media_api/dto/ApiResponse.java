package com.example.social_media_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "message", "data" })
public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;

    private ApiResponse(HttpStatus httpStatus, String message, T data) {
        this.status = httpStatus
                .getReasonPhrase()
                .toLowerCase();

        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(
            HttpStatus httpStatus,
            T data) {

        return new ApiResponse<>(
                httpStatus,
                null,
                data
        );
    }

    public static <T> ApiResponse<T> message(
            HttpStatus httpStatus,
            String message) {

        return new ApiResponse<>(
                httpStatus,
                message,
                null
        );
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}