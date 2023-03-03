package com.drey.ussdapp.utils;

import com.drey.ussdapp.exceptions.ForbiddenException;
import com.drey.ussdapp.responses.AppResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



@Data
@RequiredArgsConstructor
@Component
public class AuthKeyValidators {

    private final AdminAuthKeyValidator adminAuthKeyValidator;

    public AppResponse validateClientAuthKey(String authKey){
        try {
            adminAuthKeyValidator.validateUserAuthKey(authKey);
        }catch (ForbiddenException e){
            return getCustomResponse(HttpStatus.FORBIDDEN, "Invalid auth key.", null);
        }
        return null;
    }

    private AppResponse getCustomResponse(HttpStatus status, String message, Object data) {
        return new AppResponse(status.value(),message,message,data,null);
    }

    public AppResponse validateAdminAuthKey(String authKey){
        try {
           adminAuthKeyValidator.validateAdminAuthKey(authKey);
        }catch (ForbiddenException e){
            return getCustomResponse(HttpStatus.FORBIDDEN, "Invalid admin auth key.", null);
        }
        return null;
    }

}
