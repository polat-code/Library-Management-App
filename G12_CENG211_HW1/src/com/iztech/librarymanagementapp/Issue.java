package com.iztech.librarymanagementapp;

public class Issue {
	
	private String id;
	private String member;
	private String book;
	private String issueDate;
	private String returningDate;
	
	public Issue() {
		
	}
	public Issue(String id, String member, String book, String issueDate, String returningDate) {
		
		this.id = id;
		this.member = member;
		this.book = book;
		this.issueDate = issueDate;
		this.returningDate = returningDate;
	}
	
	public Issue(Issue oldIssue) {
		
		if(oldIssue == null) {
			System.out.println("Fatal Error");
			System.exit(0);
		}
		
		this.id = oldIssue.id;
		this.member = oldIssue.member;
		this.book = oldIssue.book;
		this.issueDate = oldIssue.issueDate;
		this.returningDate = oldIssue.returningDate;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturningDate() {
		return returningDate;
	}
	public void setReturningDate(String returningDate) {
		this.returningDate = returningDate;
	}
	
	

}
