package com.iztech.librarymanagementapp;

public class LibraryManagement {
	
	private Issue[][] issues;
	
	/* Kanka 3 tane library var ama sen 1. dimension ın uzunluğunu 2 almışsın ? Nasıl 3 tanesini 2 taneye sığdırıyon ? */ 
	public LibraryManagement() {
	
		this.issues = new Issue[2][50];
	}
	public LibraryManagement(Issue[][] issues) {
		
		this.issues = issues;
	}
	/* oldLibraryManagement dan nasıl diren issues lara ulaşabiliyorsun ? private variable değil mi ?*/
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
