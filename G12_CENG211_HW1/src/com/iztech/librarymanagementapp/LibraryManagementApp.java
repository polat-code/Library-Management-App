package com.iztech.librarymanagementapp;

public class LibraryManagementApp {

	public static void main(String[] args) {

		LibraryQuery query = new LibraryQuery();
		
		query.getMaxIssuedBook();
		query.getMemberMostIssue();
		query.getHighPenalty();
		query.getMostCopy();
		query.getFewestCopyIssuedBooks();
		query.getMemberLeastIssue();
	}

}
