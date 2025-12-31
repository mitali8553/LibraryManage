package com.library.model;

public class Book {

	public int id;
	public String bookName;
	public String author;
	public String category;
	public int quantity;
	
	
	public Book() {
		//default constructor
	}


	public Book(int id, String bookName, String author, String category, int quantity) {
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.quantity = quantity;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int i) {
		this.quantity = i;
	}
}
