package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.Account;
import org.simplilearn.workshop.model.ChequeBookRequest;
import org.simplilearn.workshop.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	private AccountService accountService;
	private TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionService(AccountService accountService, TransactionRepository transactionRepository) {
	this.accountService = accountService;
	this.transactionRepository = transactionRepository;
	}
	
	
	public void save(Account account) {
		accountService.save(account);
	}
	
	public void saveReqChequeBook(ChequeBookRequest cbr) {
		transactionRepository.save(cbr);
	}
	
	public List<ChequeBookRequest> list() {
		return transactionRepository.list();
	}
	
	public ChequeBookRequest findByRequestId(Long request_id) {
		return transactionRepository.findByRequestId(request_id);
	}
}
