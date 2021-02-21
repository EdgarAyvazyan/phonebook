package com.bdg.phonebook.service;

import com.bdg.phonebook.domain.Contact;

import java.util.Set;

public interface ContactService {
    Set<Contact> getByNameAndLastName(Set<Contact> contacts);

    Set<Contact> getByPhoneNumber(Set<Contact> contacts);

    Contact getContact(Set<Contact> contacts);

    boolean addContact(Set<Contact> contacts);

    boolean delete(Set<Contact> contacts);

    Contact editContact(Set<Contact> contacts);

    void getAllContacts(Set<Contact> contacts);

    boolean deleteContactById(Set<Contact> contacts);
}