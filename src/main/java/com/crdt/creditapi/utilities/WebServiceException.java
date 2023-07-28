package com.crdt.creditapi.utilities;

import lombok.Getter;

@Getter
public class WebServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    private final String errorCode;
    private final String errorMessage;

    public WebServiceException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
