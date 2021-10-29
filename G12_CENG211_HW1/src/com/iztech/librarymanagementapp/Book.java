package com.iztech.librarymanagementapp;

public class Book {
	
	private String id;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private String genre;
	private int quantity;
	
	
	public Book() {
		this(null, null, null, null, null, null, 0);
	}
	
	public Book(String id, String title, String author, String publisher, String edition, String genre, int quantity) {
		
		this.id = id;
		this.title = title;
		this.author= author;
		this.publisher = publisher;
		this.edition = edition;
		this.genre = genre;
		this.quantity = quantity;
		
	}
	
	/* Burdaki book 'un id veya herhangi bir özelliğine nasıl ulaşıyorsun?*/
	public Book(Book oldBook) {
		
		if(oldBook == null) {
			System.out.println("Fatal Error!");
			System.exit(0);
		}
		this.id = oldBook.id;
		this.title = oldBook.title;
		this.author= oldBook.author;
		this.publisher = oldBook.publisher;
		this.edition = oldBook.edition;
		this.genre = oldBook.genre;
		this.quantity = oldBook.quantity;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
