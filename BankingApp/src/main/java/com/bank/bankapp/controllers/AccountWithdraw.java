package com.bank.bankapp.controllers;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankapp.model.Account;
import com.bank.bankapp.repositories.AccountRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Account Withdraw")
public class AccountWithdraw {
	
	@Autowired
	AccountRepository accountRepository;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(method=RequestMethod.PUT,value="/{accno}/withdraw/{amt}")
	@ApiOperation(value="withdraw funds from account")
	public ResponseEntity<String> accDeposit(@PathVariable int accno,@PathVariable Double amt)
	{
		try {
		Optional<Account> account=accountRepository.findById(accno);
		
		if(account.isPresent())
		{
			Account acc=account.get();	
			double exisBalance=acc.getBalance();
			if(exisBalance>=amt)
			{
				double balance=acc.getBalance()-amt;
				acc.setBalance(balance);
				accountRepository.save(acc);
				return new ResponseEntity<>("Withdraw is successfull",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("Insufficient funds",HttpStatus.BAD_REQUEST);
			}
		}
		else
		{
			return new ResponseEntity<>("Account not present",HttpStatus.BAD_REQUEST);
		}
		}
		catch(Exception e)
		{
			logger.error(e);
			return new ResponseEntity<>("Deposit is unsuccessfull",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
