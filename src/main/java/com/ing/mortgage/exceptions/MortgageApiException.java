package com.ing.mortgage.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record MortgageApiException(String message, Throwable throwable, HttpStatus httpStatus,ZonedDateTime zonedDateTime) {
}
