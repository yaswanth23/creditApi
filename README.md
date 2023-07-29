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

