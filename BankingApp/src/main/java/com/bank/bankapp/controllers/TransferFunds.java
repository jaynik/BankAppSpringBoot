package com.bank.bankapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankapp.model.Account;
import com.bank.bankapp.model.Transfer;
import com.bank.bankapp.repositories.AccountRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Transfer funds")
public class TransferFunds {
	
	@Autowired
	AccountRepository accountRepository;
	
	@RequestMapping(method=RequestMethod.PUT,value="/transfer/{amt}")
	@ApiOperation(value="Transfer the funds from one account to another account")
	public ResponseEntity<String> accTransfer(@RequestBody Transfer transfer,@PathVariable double amt)
	{
		
        String to = transfer.getTo();
        String from = transfer.getFrom();
		
		Optional<Account> accountto=accountRepository.findById(Integer.parseInt(to));
		Optional<Account> accountfrom=accountRepository.findById(Integer.parseInt(from));
		
		if(accountto.isPresent() && accountfrom.isPresent())
		{
			Account accfrom=accountfrom.get();
			double balfrom=accfrom.getBalance();
			
			if(balfrom>=amt)
			{
			
				Account accto=accountto.get();	

				double balancefrom=balfrom-amt;
				accfrom.setBalance(balancefrom);
				
				double balanceto=accto.getBalance()+amt;
				accto.setBalance(balanceto);
				
				accountRepository.save(accto);
				accountRepository.save(accto);
				return new ResponseEntity<>("Transfer Successfull",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("Transfer Unsuccessfull",HttpStatus.BAD_REQUEST);
			}
		}
		else
		{
			return new ResponseEntity<>("Transfer Unsuccessfull",HttpStatus.BAD_REQUEST);
		}
		
	}

}
