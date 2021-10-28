package com.iztech.librarymanagementapp;

public class LibraryManagement {
	
	private Issue[][] issues;
	
	public LibraryManagement() {
	
		this.issues = new Issue[2][50];
	}
	public LibraryManagement(Issue[][] issues) {
		
		this.issues = issues;
	}
	public LibraryManagement(LibraryManagement oldLibraryManagement) {
		
		if(oldLibraryManagement == null) {
			System.out.println("Fatal Error!");
			System.exit(0);
		}
		
		this.issues = oldLibraryManagement.issues;
	}
	public Issue[][] getIssues() {
		return issues;
	}
	public void setIssues(Issue[][] issues) {
		this.issues = issues;
	}
	

}
