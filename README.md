# creditApi
## API Endpoint: Create Account

**Description:** Create an account for a credit card customer.

**URL:** `http://localhost:8080/api/v1/accounts`

**Method:** POST

**Request Body:**
```json
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
