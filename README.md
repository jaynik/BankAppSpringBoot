# BankAppSpringBoot
## Restful API to simulate simple banking operations

 <p>This application is secured using Spring Security.</p>
 <p>Please enter username: admin and password: test</p>

#### <p>CRUD operations on customers</p>
<p>1. Create a customer:</p>
  URI: http://localhost:3033/customers
  METHOD: POST
  Body: provide only customer details: name, email, phone --> automatically creates account details with account number, account type 
        and balance
2. Fetch all customer details: 
  URI: http://localhost:3033/customers
  METHOD: GET
3. Fetch customer details by Id: 
  URI: http://localhost:3033/customers/{id}
  METHOD: GET
4. Update customer details: 
  URI: http://localhost:3033/customers/{id}
  METHOD: PUT
5. Delete customer: 
  URI: http://localhost:3033/customers{id}
  METHOD: DELETE
  
CRUD operations on Accounts: Accounts cannot be created or updated or deleted. They can only be viewed. 
1. Get all account details
  URI: http://localhost:3033/accounts
  METHOD: GET
2. Get account details by id
  URI: http://localhost:3033/accounts/{id}
  METHOD: GET
  
Withdraw amount from account
  URI: http://localhost:3033/{accno}/withdraw/{amt}
  METHOD: PUT

Deposit amount to an account
  URI: http://localhost:3033/{accno}/deposit/{amt}
  METHOD: PUT

Transfer amount from one account to another account
  URI: http://localhost:3033/transfer/{amt}
  METHOD: PUT
  Body: {"from": "1"
        "to": "2"}

Swagger Url: http://localhost:3033/swagger-ui.html#/
             http://localhost:3033/v2/api-docs


