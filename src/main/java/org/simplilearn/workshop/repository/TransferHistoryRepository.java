package org.simplilearn.workshop.repository;

import java.util.List;

import org.simplilearn.workshop.model.TransferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferHistoryRepository extends JpaRepository<TransferHistory, Long>{

	public List<TransferHistory> findAllByUserId(long userId);
}
