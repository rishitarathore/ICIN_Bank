package org.simplilearn.workshop.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ChequeBookRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long requestId;
	private long accno;
//	private String accType;
	
	@Column(columnDefinition = "boolean default false")
	private boolean requestStatus;
	
	private LocalDateTime dateTime;

	private int no_of_pages;
		
	public long getAccno() {
		return accno;
	}

	public void setAccno(long accno) {
		this.accno = accno;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getNo_of_pages() {
		return no_of_pages;
	}
	
	public void setNo_of_pages(int no_of_pages) {
		this.no_of_pages = no_of_pages;
	}
	
//	public String getAccType() {
//		return accType;
//	}
//	
//	public void setAccType(String accType) {
//		this.accType = accType;
//	}
	
	public boolean getRequestStatus() {
		return requestStatus;
	}
	
	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	
	
}