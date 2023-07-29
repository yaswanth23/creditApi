# creditApi
API Endpoint: Create Account
Description: Create an account for a credit card customer.

URL: http://localhost:8080/api/v1/accounts

Method: POST

Request Body:
{
    "customer_id": "CUST_123",
    "account_limit": 20000,
    "per_transaction_limit": 5000
}

API Endpoint: Get Account Details
Description: Retrieve account details for a specific account by its ID.

URL: http://localhost:8080/api/v1/accounts/{account_id}

Method: GET

Path Parameter:

account_id: ID of the account to retrieve details for.
Response: The API will respond with the account details if found.

Example:
curl --location 'http://localhost:8080/api/v1/accounts/1003'

API Endpoint: Create Limit Offer
Description: Create a limit offer for an account.

URL: http://localhost:8080/api/v1/createLimitOffer

Method: POST

Request Body:
{
    "accountId": 1003,
    "limitType": "PER_TRANSACTION_LIMIT",
    "newLimit": 8000,
    "offerActivationTime": "2023-08-01T12:00:00Z",
    "offerExpiryTime": "2023-08-05T12:00:00Z"
}

API Endpoint: Get Active Limit Offers
Description: Retrieve active limit offers for a specific account by its ID and a specific active date.

URL: http://localhost:8080/api/v1/limit-offers/{account_id}

Method: GET

Path Parameter:

account_id: ID of the account to retrieve active limit offers for.
Query Parameter:

activeDate: Date to filter active offers.
Response: The API will respond with the active limit offers for the specified account and active date.

Example:
curl --location 'http://localhost:8080/api/v1/limit-offers/1003?activeDate=2023-08-04T12%3A00%3A00Z'

API Endpoint: Update Limit Offer Status
Description: Update the status of a specific limit offer.

URL: http://localhost:8080/api/v1/limit-offers/{offer_id}

Method: PATCH

Path Parameter:

offer_id: ID of the limit offer to update.
Request Body:
{
    "status": "ACCEPTED"
}

Response: The API will respond with the updated limit offer details if successful.
