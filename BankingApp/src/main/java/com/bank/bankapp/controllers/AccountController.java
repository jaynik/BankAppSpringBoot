package com.bank.bankapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankapp.model.Account;
import com.bank.bankapp.repositories.AccountRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Accounts")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	//AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET,value="/accounts")
	@ApiOperation(value="list of accounts")
	public List<Account> getAccounts()
	{
		//return accountService.getAccounts();
		List<Account> accounts = new ArrayList<Account>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
		
	}
	
	 @RequestMapping(method = RequestMethod.GET,value="/accounts/{id}") 
	 @ApiOperation(value="list of accounts by id")
	  public Optional<Account> getAccountById(@PathVariable int id) 
	  { 
		  //return accountService.getAccount(id); 
		 Optional<Account> account=accountRepository.findById(id);
		  return account; 
	  }
	 
	/*
	 * @RequestMapping(method=RequestMethod.POST,value="/accounts")
	 * 
	 * @ApiOperation(value="Add an account") public void addAccount(@RequestBody
	 * Account account) { //accountService.addAccount(account);
	 * accountRepository.save(account); }
	 * 
	 * @RequestMapping(method=RequestMethod.PUT,value="/accounts/{id}")
	 * 
	 * @ApiOperation(value="update an account") public void
	 * updateAccount(@RequestBody Account account,@PathVariable int id) {
	 * Optional<Account> acc=accountRepository.findById(id); if(acc.isPresent()) {
	 * Account accnew=acc.get(); accnew.setBalance(account.getBalance());
	 * accountRepository.save(accnew); } }
	 * 
	 * @RequestMapping(method=RequestMethod.DELETE,value="/accounts/{id}")
	 * 
	 * @ApiOperation(value="delete an account") public void
	 * deleteAccount(@PathVariable int id) { accountRepository.deleteById(id); }
	 */

}
