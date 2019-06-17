# BankAppSpringBoot
## Restful API to simulate simple banking operations

 <p>This application is secured using Spring Security.</br>
 Please enter username: admin and password: test</p>

#### CRUD operations on customers</br>
1. Create a customer:</br>
  URI: http://localhost:3033/customers</br>
  METHOD: POST</br>
  Body: provide only customer details: name, email, phone --> automatically creates account details with account number, account type 
        and balance</br>
2. Fetch all customer details:</br> 
  URI: http://localhost:3033/customers</br>
  METHOD: GET</br>
3. Fetch customer details by Id:</br> 
  URI: http://localhost:3033/customers/{id}</br>
  METHOD: GET</br>
4. Update customer details:</br> 
  URI: http://localhost:3033/customers/{id}</br>
  METHOD: PUT</br>
5. Delete customer:</br> 
  URI: http://localhost:3033/customers{id}</br>
  METHOD: DELETE
  
#### CRUD operations on Accounts: Accounts cannot be created or updated or deleted. They can only be viewed. 
1. Get all account details</br>
  URI: http://localhost:3033/accounts</br>
  METHOD: GET</br>
2. Get account details by id</br>
  URI: http://localhost:3033/accounts/{id}</br>
  METHOD: GET
  
#### Withdraw amount from account
  URI: http://localhost:3033/{accno}/withdraw/{amt}</br>
  METHOD: PUT

#### Deposit amount to an account
  URI: http://localhost:3033/{accno}/deposit/{amt}</br>
  METHOD: PUT

#### Transfer amount from one account to another account
  URI: http://localhost:3033/transfer/{amt}</br>
  METHOD: PUT</br>
  Body: {"from": "1"</br>
        "to": "2"}

### Swagger Url: 
   http://localhost:3033/swagger-ui.html#/</br>
   http://localhost:3033/v2/api-docs


