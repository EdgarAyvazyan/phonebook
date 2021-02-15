package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.service.ContactService;

import java.util.Scanner;
import java.util.Set;


public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        //TODO
        return null;
    }

    @Override
    public Set<Contact> getByPhoneNumber(Set<Contact> contacts) {
        //TODO
        return null;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        //TODO
        return null;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        System.out.println("Hello! You entered add contact section. Please, enter contact first name");
        String command = scanner.next();
        String firstName = command;
        System.out.println("Please, enter contact last name");
        command = scanner.next();
        String lastName = command;
        System.out.println("Please, enter contact Phone number");
        command = scanner.next();

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
//        contacts.remo;
        //TODO
        return false;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        //TODO
        return null;
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
        String command = scanner.next();
        for (Contact contact : contacts) {
            if (Integer.parseInt(command) == contact.getId()) {
                contacts.remove(contact);
                return true;

            }
            System.out.println(contact.toString());
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
