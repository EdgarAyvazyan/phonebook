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
        //TODO
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
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
        if (contacts != null) {
            contacts.forEach(System.out::println);
        }
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        //TODO
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
