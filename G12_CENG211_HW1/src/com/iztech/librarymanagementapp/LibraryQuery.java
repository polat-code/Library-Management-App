package com.iztech.librarymanagementapp;

public class LibraryQuery {

	private String membersCSV = "src/data/Members.csv";
	private String library01Books = "src/data/L1_Books.csv";
	private String library02Books = "src/data/L2_Books.csv";
	private String library03Books = "src/data/L3_Books.csv";
	private String library01Issue = "src/data/L1_Issues.csv";
	private String library02Issue = "src/data/L2_Issues.csv";
	private String library03Issue = "src/data/L3_Issues.csv";

	private String[] findIssuedBook(int libraryIndex, String dataPath) {

		LibraryManagement libManagement = FileIO.getIssues(library01Issue, library02Issue, library03Issue);
		Library library = FileIO.getBooks(dataPath);

		Issue[] issue = libManagement.getIssues()[libraryIndex];
		Book[] book = library.getBook();

		int max = 0;
		String maxName = null;
		String tempMax = null;

		for (int i = 0; i < issue.length; i++) {
			int count = 1;
			for (int j = i + 1; j < issue.length; j++) {

				if (issue[j] != null) {

					if (issue[i].getBook().equals(issue[j].getBook())) {
						count++;
					}

				} else {
					break;
				}
			}
			if (max < count) {
				max = count;
				tempMax = issue[i].getBook();
			}
		}
		for (Book maxBook : book) {
			if (maxBook != null && maxBook.getId().equals(tempMax)) {
				maxName = maxBook.getTitle();
			}
		}
		String[] values = { Integer.toString(max), maxName };

		return values;

	}

	public void getMaxIssuedBook() {

		String[] library01Values = findIssuedBook(0, library01Books);
		String[] library02Values = findIssuedBook(1, library02Books);
		String[] library03Values = findIssuedBook(2, library03Books);

		int library01MaxNumber = Integer.parseInt(library01Values[0]);
		int library02MaxNumber = Integer.parseInt(library02Values[0]);
		int library03MaxNumber = Integer.parseInt(library03Values[0]);

		String maxName = null;

		if (library01MaxNumber > library02MaxNumber && library01MaxNumber > library03MaxNumber) {
			maxName = library01Values[1];
		} else if (library02MaxNumber > library01MaxNumber && library02MaxNumber > library03MaxNumber) {
			maxName = library02Values[1];
		} else {
			maxName = library03Values[1];
		}

		System.out.println("1) " + maxName);
	}

	public void getMemberMostIssue() {

		LibraryManagement libManagement = FileIO.getIssues(library01Issue, library02Issue, library03Issue);
		Member[] members = FileIO.getMembers(membersCSV);

		Issue[][] issues = libManagement.getIssues();
		String maxMember = null;

		int max = 0;
		for (Member member : members) {
			int count = 0;
			for (int j = 0; j < 3; j++) {

				for (Issue issue : issues[j]) {

					if (issue != null) {

						if (member.getId().equals(issue.getMember())) {
							count++;
							// System.out.println(member.getName());
						}
					}
				}
				if (max < count) {
					max = count;
					maxMember = member.getName();
				}
			}
		}
		System.out.println("2) " + maxMember);
	}

	public void getHighPenalty() {

		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		LibraryManagement libManagement = FileIO.getIssues(library01Issue, library02Issue, library03Issue);
		Issue[][] issue = libManagement.getIssues();

		String[] tempReturnDate = null;
		String[] tempIssueDate = null;

		int tempInt1 = 0, tempInt2 = 0;
		int total = 0, max = 0;
		double maxDayFee = 0.0;

		for (int i = 0; i < 3; i++) {

			for (Issue issues : issue[i]) {

				if (issues != null) {

					tempReturnDate = issues.getReturningDate().split("-");
					tempIssueDate = issues.getIssueDate().split("-");

					for (int j = 0; j < months.length; j++) {

						if (tempReturnDate[1].equals(months[j])) {
							tempInt1 = j;
						}

						if (tempIssueDate[1].equals(months[j])) {
							tempInt2 = j;
						}
					}

					if (max < Math.abs(tempInt2 - tempInt1)) {
						max = Math.abs(tempInt2 - tempInt1);
						if (tempInt1 < tempInt2) {
							total = 0;
							for (int k = 0; k < tempInt1; k++) {
								total += days[k];
							}
							for (int l = tempInt2; l < days.length; l++) {
								total += days[l];
							}

						} else {
							for (int k = tempInt2; k < tempInt1; k++) {
								total += days[k];
							}
						}
						total = total + Integer.parseInt(tempReturnDate[0]) - Integer.parseInt(tempIssueDate[0]);

					}

				}
			}

		}
		maxDayFee = total - 14.0;
		maxDayFee *= 0.5;
		System.out.println("3) " + maxDayFee);

	}

	public void getMostCopy() {

		Library library = null;
		Book[] books = null;
		String[] libraries = { library01Books, library02Books, library03Books };
		int max = 0;
		String maxName = null;

		for (int i = 0; i < libraries.length; i++) {

			library = FileIO.getBooks(libraries[i]);
			books = library.getBook();

			for (Book book : books) {

				if (book != null) {

					if (max < book.getQuantity()) {
						max = book.getQuantity();
						maxName = book.getTitle();
					}
				}

			}
		}

		System.out.println("4) " + maxName);
	}

	public void getFewestCopyIssuedBooks() {

		LibraryManagement libManagement = FileIO.getIssues(library01Issue, library02Issue, library03Issue);
		Issue[][] issues = libManagement.getIssues();

		String[] libraries = { library01Books, library02Books, library03Books };
		Library library = null;
		Book[] books;

		String minName = null, minId = null;
		int min = 100;

		for (int i = 0; i < libraries.length; i++) {

			library = FileIO.getBooks(libraries[i]);
			books = library.getBook();

			for (Book book : books) {

				if (book != null) {

					if (min > book.getQuantity()) {
						min = book.getQuantity();
						minId = book.getId();

						for (int j = 0; j < issues.length; j++) {
							for (int k = 0; k < issues[j].length; k++) {
								if (issues[j][k] != null) {
									if (issues[j][k].getBook().equals(minId)) {
										minName = book.getTitle();
									}
								}
							}
						}
					}
				}

			}
		}
		System.out.println("5) " + minName);
	}

	public void getMemberLeastIssue() {

		LibraryManagement libManagement = FileIO.getIssues(library01Issue, library02Issue, library03Issue);
		Issue[][] issues = libManagement.getIssues();

		Member[] members = FileIO.getMembers(membersCSV);

		int minCount = 100;
		String minName = null;

		for (Member member : members) {
			int count = 0;
			for (int j = 0; j < issues[2].length; j++) {
				if (issues[2][j] != null) {
					if (issues[2][j].getMember().equals(member.getId())) {
						count++;
					}
				}

			}
			if (minCount > count) {
				minCount = count;
				minName = member.getName();
			}
		}
		System.out.println("6) " + minName);

	}

}
