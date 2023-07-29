package com.crdt.creditapi.constants;

public class ApiServiceUrl {
    public static final String V1_API_URL = "/api/v1";
    public static final String CREATE_CUSTOMER_ACCOUNTS_API_URL = "/accounts";
    public static final String GET_ACCOUNT_DETAILS_API_URL = "/accounts/{account_id}";
    public static final String CREATE_LIMIT_OFFER_API_URL = "/createLimitOffer";
    public static final String GET_LIMIT_OFFER_API_URL = "/limit-offers/{account_id}";
    public static final String UPDATE_LIMIT_OFFER_STATUS_API_URL = "/limit-offers/{limit_offer_id}";

    private ApiServiceUrl() {
    }
}
