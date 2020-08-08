package com.udemy;

import java.util.Scanner;

public class MobilePhone {
    private static Scanner scanner = new Scanner(System.in);
    private static Contacts contactsList = new Contacts();

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();
        while (!quit) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0:
                        printInstructions();
                        break;
                    case 1:
                        contactsList.printContactList();
                        break;
                    case 2:
                        addContact();
                        break;
                    case 3:
                        modifyContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        searchContact();
                        break;
                    case 6:
                        quit = true;
                        break;
                }
            } else {
                System.out.println("Invalid value, please try again.");
                scanner.nextLine();
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact.");
        System.out.println("\t 3 - To modify a contact in the list.");
        System.out.println("\t 4 - To remove a contact from the list.");
        System.out.println("\t 5 - To search for a contact in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    private static void addContact() {
        System.out.print("Enter the contact name: ");
        contactsList.addContact(scanner.nextLine());
        System.out.print("Enter the contact number: ");
        contactsList.addNumber(scanner.nextLine());
    }

    private static void modifyContact() {
        System.out.print("Enter contact name to edit: ");
        String currentName = scanner.nextLine();
        if (contactsList.modifyContactList(currentName)) {
            System.out.println("Update successful");
        } else {
            printInstructions();
        }
    }

    private static void removeContact() {
        System.out.print("Enter contact to delete: ");
        String name = scanner.nextLine();
        if (contactsList.removeContact(name)) {
            System.out.println("Contact deleted.");
        } else {
            printInstructions();
        }
    }

    private static void searchContact() {
        System.out.print("Contact to search for: ");
        String searchContact = scanner.nextLine();
        if (contactsList.onList(searchContact)) {
            System.out.println("Found " + searchContact);
            contactsList.printContact(searchContact);
        } else {
            System.out.println("No contact with that name on the list.");
            printInstructions();
        }
    }
}
