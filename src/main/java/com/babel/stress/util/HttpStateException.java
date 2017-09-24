package com.babel.stress.util;


import com.babel.stress.exception.SystemException;

public class HttpStateException extends SystemException {

    public HttpStateException(String code, String message) {
        super(code, message);
    }
}
