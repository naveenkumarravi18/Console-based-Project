package library;

import java.util.Scanner;
import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Userdetails use=new Userdetails();
        Admin ad=new Admin();
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("0.SIGN IN");
            System.out.println("1. LOG IN TO YOUR ACCOUNT");
            System.out.print("Enter choice: ");
            boolean b1=false;

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                	System.out.print("Enter name: ");
                	 String na=scanner.next();
          
                	 System.out.print("Are You Willing To Subscribe");
                	 String s=scanner.next();
                	 System.out.print("ENTER PASSWORD");
                	 String p=scanner.next();
                	 boolean b=false;
                	 if(s.contains("YES")) {
                		 b=true;}
                		  use.addUser(new User(na,b,p));
                		 break;
                case 1:
                	   System.out.println("Enter your name ");
                	   String su=scanner.next();
                	   System.out.println("Enter your password :");
                	   String sb=scanner.next();
                	   b1=use.searchUser(su,sb);
                	   if(b1)
                	   System.out.println("Welcome "+su);
                	   else
                		System.out.println("PLEASE SIGN IN TO VIEW THE LIBRARY");
                	   break;
                default:
                    System.out.println("Invalid choice. Try again.");
                	}
            while(b1)
            {
            	System.out.println("1. Add Book");
                System.out.println("2. View All Books");
                System.out.println("3. Search Book");
                System.out.println("4. Delete Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
            	int ch=scanner.nextInt();
            	switch(ch) {
                case 1:
                    System.out.println("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new Book(title, author, year));
                    break;

                case 2:
                    List<Book> books = library.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book book : books) {
                            System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                                    ", Author: " + book.getAuthor() + ", Year: " + book.getYear());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    int searchTitle = scanner.nextInt();
                    library.searchBook(searchTitle);
                    break;
                case 4:
                    System.out.print("Enter book ID to delete: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    library.deleteBook(bookId);
                   break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }}}


