package org.simplilearn.workshop.model;

import java.time.LocalDateTime;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TransferHistory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transferId;
	private long senderAccount;
	private long recipientAccount;
	private long amount;
	private LocalDateTime dateTime;
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public long getTransferId() {
		return transferId;
	}
	
	public void setTransferId(long transferId) {
		this.transferId = transferId;
	}
	
	public long getSenderAccount() {
		return senderAccount;
	}
	
	public void setSenderAccount(long senderAccount) {
		this.senderAccount = senderAccount;
	}
	
	public long getRecipientAccount() {
		return recipientAccount;
	}
	
	public void setRecipientAccount(long recipientAccount) {
		this.recipientAccount = recipientAccount;
	}
	
	public long getAmount() {
		return amount;
	}
	
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}