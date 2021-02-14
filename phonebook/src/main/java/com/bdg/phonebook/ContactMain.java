package com.bdg.phonebook;

import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.service.impl.ContactServiceImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        ContactServiceImpl service = new ContactServiceImpl();
        Set<Contact> contacts = new HashSet<>();

        System.out.println("Welcome to phone book");
        System.out.println("Please follow to commands");

        while (true) {
            System.out.println("press 0 for adding contact");
            System.out.println("press 1 for deleting contact");
            System.out.println("press 2 for editing contact");
            System.out.println("press 3 for getting by contact's phone number");
            System.out.println("press 4 for getting by contact's name");
            System.out.println("press 5 for getting all contacts");
            System.out.println("press 6 for deleting contact by Id");

            command = scanner.next();

            switch (command) {
                case "0": {
                    final boolean isAdded = service.addContact(contacts);
                    if (isAdded) {
                        System.out.println("You successfully add contact");
                    } else {
                        System.out.println("Sorry something went wrong");
                    }
                    break;
                }
                case "1": {
                    final boolean isDeleted = service.delete(contacts);
                    if (isDeleted) {
                        System.out.println("Contact is deleted");
                    } else {
                        System.out.println("This contact can not be deleted");
                    }
                    break;
                }
                case "2": {
                    final Contact contact = service.editContact(contacts);
                    if (contact != null) {
                        System.out.println("Edited");
                    } else {
                        System.out.println("Sorry this contact can not be edited");
                    }
                    break;
                }
                case "3": {
                    final Set<Contact> byPhoneNumber = service.getByPhoneNumber(contacts);
                    if (byPhoneNumber.size() > 0) {
                        service.getAllContacts(byPhoneNumber);
                    } else {
                        System.out.println("There is no contact by this phone number");
                    }
                    break;
                }
                case "4": {
                    final Set<Contact> byNameAndLastName = service.getByNameAndLastName(contacts);
                    if (byNameAndLastName.size() > 0) {
                        service.getAllContacts(byNameAndLastName);
                    } else {
                        System.out.println("There is no contact with this name and lastname");
                    }
                    break;
                }

                case "5": {
                    service.getAllContacts(contacts);
                    break;
                }
                case "6":{
                    service.deleteContactById(contacts);
                    break;
                }
                default:{
                    System.out.println("You are enter wrong command");
                }
            }
        }
    }
}
