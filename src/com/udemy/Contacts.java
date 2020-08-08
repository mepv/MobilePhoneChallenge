package com.udemy;

import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String phoneNumber;
    private ArrayList<String> contactsList = new ArrayList<>();
    private ArrayList<String> phoneNumberContactsList = new ArrayList<>();

    public Contacts() {
    }

    public void printContact(String name) {
        int position = findName(name);
        System.out.println(("Contact name " + contactsList.get(position) + " - " + phoneNumberContactsList.get(position)));
    }

    public void addContact(String name) {
        contactsList.add(name);
    }

    public void addNumber(String phoneNumber) {
        phoneNumberContactsList.add(phoneNumber);
    }

    public void printContactList() {
        System.out.println("You have " + contactsList.size() + " contacts on your list.");
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println((i + 1) + ". " + contactsList.get(i) + " - " + phoneNumberContactsList.get(i));
        }
    }

    public boolean modifyContactList(String currentName) {
        String name;
        String phoneNumber;
        if (onList(currentName)) {
            int position = findName(currentName);
            System.out.print("Enter new contact name: ");
            name = scanner.nextLine();
            modifyContactList(position, name);
            System.out.print("Enter new contact number: ");
            phoneNumber = scanner.nextLine();
            modifyNumber(position, phoneNumber);
            System.out.println("Contact " + currentName + " has been modified");
            return true;
        } else {
            System.out.println("No contact with that name on the list. Would you like to add it?");
            if (scanner.nextLine().equals("yes".toLowerCase())) {
                System.out.print("Enter the contact name: ");
                String newName = scanner.nextLine();
                addContact(newName);
                System.out.print("Enter the contact number: ");
                String newNumber = scanner.nextLine();
                addNumber(newNumber);
                return true;
            } else {
                return false;
            }
        }
    }

    private void modifyContactList(int position, String name) {
        contactsList.set(position, name);
    }

    private void modifyNumber(int position, String phoneNumber) {
        phoneNumberContactsList.set(position, phoneNumber);
    }

    public boolean removeContact(String name) {
        if (onList(name)) {
            int position = findName(name);
            removeContact(position);
            return true;
        } else {
            System.out.println("No contact with that name on the list.");
        }
        return false;
    }

    private void removeContact(int position) {
        contactsList.remove(position);
        phoneNumberContactsList.remove(position);
    }

    public boolean onList(String name) {
        int position = findName(name);
        return position >= 0;
    }

    private int findName(String name) {
        return contactsList.indexOf(name);
    }
}
