package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.repository.AccountRepository;
import org.simplilearn.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	private UserRepository userRepository;
	private AccountRepository accountRepository;
	
	@Autowired
	public void AccoutService(UserRepository userRepository, AccountRepository accountRepository) {
		this.userRepository = userRepository;
		this.accountRepository = accountRepository;
	}
	
	private final String bankCode = "3914";
	private final String countryCode = "91";
	private final String branchCode = "820";
	private final String accountcode="1";
	
	public Account newAccount(String username,long userId) {
		Account account = new Account();
		account.setUsername(username);
		account.setAccno(generate_saving(userId));
		account.setUser(userRepository.findByUsername(username));
		return accountRepository.save(account);
	}

	
	public long generate_saving(long userId) {
		String accNo = bankCode+countryCode+branchCode+accountcode+String.valueOf(userId);
		return Long.parseLong(accNo);
	}
	
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
		
	}
	
	public Account findByAccNo(Long accno) {
		return accountRepository.findByAccno(accno);
		
	}

	public List<Account> list() {
		return accountRepository.findAll();
	}


	public void save(Account account) {
		accountRepository.save(account);
	}

}
