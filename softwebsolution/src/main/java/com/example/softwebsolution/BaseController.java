package com.example.softwebsolution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author mehul on 26/08/2022
 */
@RestController
public class BaseController {


    public static final int SUCCESS = 1;
    public static final int FAIL = 0;
    @Autowired
    private MessageService messageService;

    protected <T> ResponseEntity<?> okSuccessResponse(T t, String messageId) {
        return new ResponseEntity<>(new ApiResponse<>(t, messageService.getMessage(messageId), SUCCESS), HttpStatus.OK);
    }

    protected <T> ResponseEntity<?> okFailResponse(T t, String messageId) {
        return new ResponseEntity<>(new ApiResponse<>(t, messageService.getMessage(messageId), FAIL), HttpStatus.OK);
    }

}
