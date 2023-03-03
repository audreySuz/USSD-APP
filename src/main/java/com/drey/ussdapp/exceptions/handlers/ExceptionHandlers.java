package com.drey.ussdapp.exceptions.handlers;

import com.drey.ussdapp.exceptions.ForbiddenException;
import com.drey.ussdapp.exceptions.InsufficientBalanceException;
import com.drey.ussdapp.exceptions.NotFoundException;
import com.drey.ussdapp.responses.AppResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionHandlers {


@ExceptionHandler(NotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
public AppResponse handleNotFoundException(final NotFoundException ex) {
    log.error("Not found error: {} ", ex.getMessage());
    return new AppResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
            ex.getMessage(), null, ex.getMessage());
}

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ResponseBody
    public AppResponse handleInsufficientBalanceException(final InsufficientBalanceException ex) {
        log.error("Insufficient Balance error: {} ", ex.getMessage());
        return new AppResponse(HttpStatus.EXPECTATION_FAILED.value(), ex.getMessage(),
                ex.getMessage(), null, ex.getMessage());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public AppResponse handleForbiddenException(final ForbiddenException ex) {
        log.error("Forbidden error: {} ", ex.getMessage());
        return new AppResponse(HttpStatus.FORBIDDEN.value(), ex.getMessage(),
                ex.getMessage(), null, ex.getMessage());
    }

}