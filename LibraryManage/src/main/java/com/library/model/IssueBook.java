package com.library.model;

public class IssueBook {

	public int id;
	public int bookId;
	public int memberId;
	public String issueDate;
	public String returnDate;
	public String status;
	
	
	public IssueBook() {
		//default constructor
	}


	public IssueBook(int id, int bookId, int memberId, String issueDate, String returnDate, String status) {
		this.id = id;
		this.bookId = bookId;
		this.memberId = memberId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}


	public String getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
