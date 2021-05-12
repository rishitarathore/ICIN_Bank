package org.simplilearn.workshop.service;

import java.util.List;

import org.simplilearn.workshop.model.TransferHistory;
import org.simplilearn.workshop.repository.TransferHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferHistoryService {
	
	private TransferHistoryRepository transferHistoryRepository;
	
	@Autowired
	public TransferHistoryService(TransferHistoryRepository transferHistoryRepository) {
		this.transferHistoryRepository = transferHistoryRepository;
	}
	
	public void save(TransferHistory transferHistory) {
		transferHistoryRepository.save(transferHistory);
	}

	public List<TransferHistory> findAllByUserId(long userId){
		return transferHistoryRepository.findAllByUserId(userId);
	}
}
