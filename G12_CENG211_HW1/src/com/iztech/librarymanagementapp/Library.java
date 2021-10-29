package com.iztech.librarymanagementapp;

public class Library {
	
	/* book arrayı birden fazla book içerdiği için book ismi yerine books koysan çok daha iyi olur bence.. */
	private Book[] book;
	
	public Library() {
		this.book = new Book[100];
	}
	public Library(Book[] book) {
		this.book = book;
	}
	public Library(Library oldLibrary) {
		
		if(oldLibrary == null) {
			System.out.println("Fatal Error");
			System.exit(0);
		}
		this.book = oldLibrary.book;
	}
	public Book[] getBook() {
				
		Book[] copyBookArray = new Book[this.book.length];
		for(int i=0; i<this.book.length ; i++) {
			copyBookArray[i] = this.book[i];
		}
		return copyBookArray;
	}
	public void setBook(Book[] book) {
		
		this.book = book;
	}
	


}
