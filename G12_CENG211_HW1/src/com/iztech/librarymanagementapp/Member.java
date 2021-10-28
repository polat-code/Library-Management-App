package com.iztech.librarymanagementapp;

public class Member {
	
	private String id;
	private String name;
	private String email;
	
	public Member(String id, String name, String email) {
		
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public Member(Member oldMember) {
		
		if (oldMember == null) {
			System.out.println("Fatal Error");
			System.exit(0);
		}
		
		this.id = oldMember.id;
		this.name = oldMember.name;
		this.email = oldMember.email;
		
	}
	
	public String getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}


}

