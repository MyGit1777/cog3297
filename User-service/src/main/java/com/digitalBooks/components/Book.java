package com.digitalBooks.components;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


public class Book {

	private int authorId;
		
	private String author;
	
	private String bookTitle;
	
	private String category;
	
	private String publisher;
	
	private boolean active;
	
	private String publishedDate;
	
	private int price;
	
	private String status;

	private String chapter;
	
	private byte[] logo;
	
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	private String createdBy; //user
	
	private int subscriptionId;
	

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Book(int authorId, String author, String bookTitle, String category, String publisher, boolean active,
			String publishedDate, int price, String status, String chapter, String createdBy, int subscriptionId) {
		super();
		this.authorId = authorId;
		this.author = author;
		this.bookTitle = bookTitle;
		this.category = category;
		this.publisher = publisher;
		this.active = active;
		this.publishedDate = publishedDate;
		this.price = price;
		this.status = status;
		this.chapter = chapter;
		this.createdBy = createdBy;
		this.subscriptionId = subscriptionId;
	}

	public Book() {
		
	}

	public Book(Book book) {
		
	}
}
