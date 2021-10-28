package com.iztech.librarymanagementapp;

import java.io.*;
import java.util.Scanner;

public class FileIO {

	private Member[] getDataMembers(String dataPath) {

		Scanner inFile = null;
		String line = null;
		String sepBy = ",";
		String[] data;
		Member[] members = new Member[4];

		try {

			inFile = new Scanner(new File(dataPath));

			inFile.nextLine(); // read first sentence which is blank
			inFile.nextLine(); // pass the admin

			int index = 0;
			while (inFile.hasNextLine()) {

				line = inFile.nextLine();
				data = line.split(sepBy);
				Member member = new Member(data[0], data[1], data[2]);
				members[index] = member;
				index++;
			}
			inFile.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("System Error" + e.getMessage());
		}

		return members;
	}

	private Book[] getDataBooks(String dataPath) {

		Scanner inFile = null;
		String line = null;
		String sepBy = ",";

		String[] data = null;
		Book[] books = new Book[50];

		try {

			inFile = new Scanner(new File(dataPath));

			int index = 0;

			while (inFile.hasNextLine()) {

				line = inFile.nextLine();
				data = line.split(sepBy);
				Book book = new Book(data[0], data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]));
				books[index] = book;

				index++;

			}
			
			inFile.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("System Error" + e.getMessage());
		}

		return books;

	}

	private Issue[] getDataIssues(String dataPath) {

		Scanner inFile = null;
		String line = null;
		String sepBy = ",";

		String[] data;
		Issue[] issues = new Issue[50];

		try {

			inFile = new Scanner(new File(dataPath));

			int index = 0;
			while (inFile.hasNextLine()) {

				line = inFile.nextLine();
				data = line.split(sepBy);
				Issue issue = new Issue(data[0], data[1], data[2], data[3], data[4]);
				issues[index] = issue;

				index++;

			}
			inFile.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found" + e.getMessage());
		} catch (IOException e) {
			System.out.println("System Error" + e.getMessage());
		}
		return issues;
	}

	public static Member[] getMembers(String dataPath) {
		
		FileIO file = new FileIO();

		Member[] members = file.getDataMembers(dataPath);
		
		return members;
	}

	public static Library getBooks(String dataPath) {

		FileIO file = new FileIO();
		Library library = new Library(file.getDataBooks(dataPath));

		return new Library(library);

	}

	public static LibraryManagement getIssues(String... dataPath) {

		FileIO file = new FileIO();
		
		Issue[][] issues = new Issue[3][50];
		int index = 0;

		for(int i=0; i<3 ; i++) {
			index = 0;
			for(int j=0; j<file.getDataIssues(dataPath[i]).length;j++) {
				issues[i][j] = file.getDataIssues(dataPath[i])[j];
			}
		}

		return new LibraryManagement(issues);
	}

	public static void main(String[] args) {
//
		Member[] member = FileIO.getMembers("src/data/Members.csv");
		//Library library = FileIO.getBooks("src/data/L1_Books.csv");
		
		 //System.out.println(library.getBook()[6].getAuthor());
//
		 System.out.println(member[1].getName());
//
		 LibraryManagement libraryManagement = FileIO.getIssues("src/data/L1_Issues.csv");
//
//		// System.out.println(FileIO.getDataIssues("src/data/L3_Issues.csv").length);
	}

}
