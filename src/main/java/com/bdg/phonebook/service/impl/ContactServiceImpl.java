package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.service.ContactService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);
    String command;

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> contactSet = new HashSet<>();
        System.out.println("Please, enter Name of the contact that you want to get.");
        String firstName = scanner.next();
        System.out.println("Please, enter Surname of the contact that you want to get.");
        String lastName = scanner.next();
        System.out.println("With the given name and surname the following contact/s is/are found:");
        for (Contact contact : contacts) {
            if (firstName.equals(contact.getFirstName()) && lastName.equals(contact.getLastName())) {
                contactSet.add(contact);
            }
        }
        return contactSet;
    }

    @Override
    public Set<Contact> getByPhoneNumber(Set<Contact> contacts) {
        Set<Contact> contactSet = new HashSet<>();
        System.out.println("Please, enter Phone number of the contact that you want to get.");
        command = scanner.next();
        System.out.println("With the given phone number the following contact/s is/are found:");
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().contains(command)) {
                contactSet.add(contact);
            }
        }
        return contactSet;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        for (Contact contactEntity : contacts) {
            if (contactEntity.equals(contact)) {
                System.out.println(contactEntity);
                return contactEntity;
            }
        }
        return null;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        System.out.println("Hello! You entered add contact section. Please, enter contact first name");
        command = scanner.next();
        String firstName = command;
        System.out.println("Please, enter contact last name");
        command = scanner.next();
        String lastName = command;
        System.out.println("Please, enter contact Phone number");
        command = scanner.next();

        boolean state = false;
        while (!state) {
            try {
                int number = Integer.parseInt(command);
                command = number + "";
                state = true;
            } catch (NumberFormatException e) {
                System.out.print("Your input value is not a number. PLease enter only numbers.\n");
                command = scanner.next();
            }
        }

        String phoneNumber = command;
        System.out.println("Please, enter contact email");
        command = scanner.next();
        String email = command;
        System.out.println("Please, enter contact contact type");
        command = scanner.next();
        String contactType = command;
        contacts.add(new Contact(firstName, lastName, phoneNumber, email, contactType));

        return true;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        Set<Contact> contactSet = getByNameAndLastName(contacts);
        getAllContacts(contactSet);
        System.out.println("Please, enter phone number to delete the contact.");
        command = scanner.next();
        for (Contact contact : contactSet) {
            if (contact.getPhoneNumber().equals(command)) {
                return contacts.remove(contact);
            }
        }
        return false;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        Set<Contact> contactSet = getByNameAndLastName(contacts);
        getAllContacts(contactSet);
        Object[] contactArray = contactSet.toArray();
        Contact firstContact = (Contact) contactArray[0];

        System.out.println("Enter firstname to change contact's firstname");
        command = scanner.next();
        firstContact.setFirstName(command);
        System.out.println("Enter lastname to change contact's lastname");
        command = scanner.next();
        firstContact.setLastName(command);
        System.out.println("Enter phone number to change contact's phone number");
        command = scanner.next();

        boolean state = false;
        while (!state) {
            try {
                int number = Integer.parseInt(command);
                command = number + "";
                state = true;
            } catch (NumberFormatException e) {
                System.out.print("Your input value is not a number. PLease enter only numbers.\n");
                command = scanner.next();
            }
        }

        firstContact.setPhoneNumber(command);
        System.out.println("Enter email to change contact's email");
        command = scanner.next();
        firstContact.setEmail(command);
        System.out.println("Enter type to change contact's type");
        command = scanner.next();
        firstContact.setContactType(command);

        return firstContact;
    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        System.out.println("Please, enter ID of the contact that you want to delete.");
        command = scanner.next();
        for (Contact contact : contacts) {
            if (Integer.parseInt(command) == contact.getId()) {
                System.out.println("Contact with the given ID is removed.");
                return contacts.remove(contact);
            }
        }
        return false;
    }

    private static Contact updatedContactToContact(Contact source, Contact destination) {
        //TODO
        return null;
    }

    public static Contact createContact() {
        //TODO
        return null;
    }
}
