package com.mytelecom.xyzapplication.error;

import com.mytelecom.xyzapplication.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> customerNotFound(CustomerNotFound customerNotFound){
            ErrorMessage errorMessage=new ErrorMessage(customerNotFound.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> phoneNumNotFound(PhoneNumNotFound phoneNumNotFound){
        ErrorMessage errorMessage=new ErrorMessage(phoneNumNotFound.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }


}
