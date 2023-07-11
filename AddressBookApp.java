/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.book.system;

import java.util.List;
import java.util.Scanner;

public class AddressBookApp {
    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("=== Address Book ===");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    displayAllContacts();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private static void addContact() {
        System.out.println("=== Add Contact ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email address: ");
        String emailAddress = scanner.nextLine();

        // Create and add the contact to the address book
        Contact contact = new Contact(name, phoneNumber, emailAddress);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void removeContact() {
        System.out.println("=== Remove Contact ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        // Search for the contact
        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            // Remove the contact from the address book
            addressBook.removeContact(contact);
            System.out.println("Contact removed successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void searchContact() {
        System.out.println("=== Search Contact ===");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        // Search for the contact
        Contact contact = addressBook.searchContact(name);
        if (contact != null) {
            // Display contact information
            System.out.println("Name: " + contact.getName());
            System.out.println("Phone Number: " + contact.getPhoneNumber());
            System.out.println("Email Address: " + contact.getEmailAddress());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayAllContacts() {
        System.out.println("=== All Contacts ===");
        List<Contact> contacts = addressBook.getAllContacts();

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println("Name: " + contact.getName());
                System.out.println("Phone Number: " + contact.getPhoneNumber());
                System.out.println("Email Address: " + contact.getEmailAddress());
                System.out.println("------------------");
            }
        }
    }
}
