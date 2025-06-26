package com.Library;
import java.util.*;

public class LibrarySystem
{
	static class Book {
        int id;
        String title;
        boolean isIssued;

        Book(int id, String title) {
            this.id = id;
            this.title = title;
            this.isIssued = false;
        }
    }

    static class User {
        int userId;
        String name;

        User(int userId, String name) {
            this.userId = userId;
            this.name = name;
        }
    }

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    

    static void addBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        books.add(new Book(id, title));
        System.out.println("Book added.");
    }

    static void addUser() {
        System.out.print("Enter user ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter user name: ");
        String name = sc.nextLine();
        users.add(new User(id, name));
        System.out.println("User added.");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println("Book ID: " + b.id + ", Title: " + b.title + ", Issued: " + b.isIssued);
        }
    }

    static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        for (User u : users) {
            System.out.println("User ID: " + u.userId + ", Name: " + u.name);
        }
    }

    static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = sc.nextInt();
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: addUser(); break;
                case 3: viewBooks(); break;
                case 4: viewUsers(); break;
                case 5: issueBook(); break;
                case 6: returnBook(); break;
                case 7: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }

        } while (choice != 7);
    }
}
