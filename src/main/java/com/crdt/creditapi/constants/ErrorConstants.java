package com.crdt.creditapi.constants;

public class ErrorConstants {
    public static final String ERROR_STATUS_CODE_500 = "500";
    public static final String ERROR_STATUS_CODE_500_MESSAGE = "Internal Error: Something went wrong";
    public static final String ERROR_STATUS_CODE_404 = "404";
    public static final String ACCOUNT_ERROR_STATUS_CODE_404_MESSAGE = "Account not found";
    public static final String LIMIT_ERROR_STATUS_CODE_404_MESSAGE = "Limit Offer Id not found";
    public static final String LIMIT_NOT_PENDING_ERROR_STATUS_CODE_404_MESSAGE = "Limit Offer is already ";
    public static final String NEW_LIMIT_LESS_THAN_CURRENT_ERROR_STATUS_CODE_10001 = "1001";
    public static final String NEW_LIMIT_LESS_THAN_CURRENT_ERROR_STATUS_CODE_10001_MESSAGE = "new limit is less than the current limit";


    private ErrorConstants() {
    }

}
