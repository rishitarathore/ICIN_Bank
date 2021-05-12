package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.TransactionHistory;

import org.simplilearn.workshop.repository.TransactionHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionHistoryService {
	
	private TransactionHistoryRepository transactionHistoryRepository;
	
	@Autowired
	public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository) {
		this.transactionHistoryRepository = transactionHistoryRepository;
	}
	
	public void save(TransactionHistory transactionHistory) {
		transactionHistoryRepository.save(transactionHistory);
	}

	public List<TransactionHistory> findAllByUserId(long userId){
		return transactionHistoryRepository.findAllByUserId(userId);
	}
}
