package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Address;
import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.service.ContactService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);
    private Object Address;

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the name");
            String firstName = scanner.next();
            System.out.println("Please enter the last name");
            String lastName = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Contact> getByPhoneNumber(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the phone number");
            String phoneNumber = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        if (contact != null && contacts != null) {
            for (Contact item : contacts) {
                if (contact.equals(item)) {
                    return contact;
                }
            }
        }
        return null;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        Contact contact = createContact();
        if (contact != null) {
            contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        System.out.println("Please enter the phone number You want to delete");
        String phoneNumber = scanner.next();
        Contact contact = null;
        for (Contact item : contacts) {
            if (item.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        System.out.println("Please enter the Name of contact which You want to edit");
        Contact editedContact = null;
        if (contacts != null) {
            Contact contact = new Contact();
            System.out.println("For editing contact enter:");
            System.out.println("Enter contact's first name");
            contact.setFirstName(scanner.next());
            System.out.println("Enter contact's last name");
            contact.setLastName(scanner.next());
            System.out.println("Enter contact's phone number");
            contact.setPhoneNumber(scanner.next());
            System.out.println("Enter contact's email");
            contact.setEmail(scanner.next());
            Contact contactToEdit = getContact(contact, contacts);
            Contact newcontact = createContact();
            return editedContact;
        }

        return null;

    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        if (!contacts.isEmpty()) {
            System.out.println("This is our phone book");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        } else System.out.println("The phone book is empty");
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        System.out.println("Please enter the contact ID You want to delete");
        int id = scanner.nextInt();
        Contact contact = null;
        for (Contact item : contacts) {
            if (item.getId() == id) {
                contact = item;
            }
        }
        if (contact != null) {
            contacts.remove(contact);
            return true;
        }
        return false;
    }

    private static Contact updatedContactToContact(Contact source, Contact destination) {
        System.out.println("Please enter the Name of contact which You want to update");
        Contact updatedContact = null;
        if (source != null) {
            Contact contact = new Contact();
            System.out.println("For updating contact enter:");
            System.out.println("Enter contact's first name");
            destination.setFirstName(source.getFirstName());
            System.out.println("Enter contact's last name");
            destination.setLastName(source.getLastName());
            System.out.println("Enter contact's phone number");
            destination.setPhoneNumber(source.getPhoneNumber());
            System.out.println("Enter contact's email");
            destination.setEmail(source.getEmail());
            return destination;
        }
        return updatedContact;
    }

    public Contact createContact() {
        System.out.println("Please create the contact");
        Contact contact = new Contact();
        System.out.println("Please enter the name");
        String firstName = scanner.next();
        contact.setFirstName(firstName);
        System.out.println("Please enter the last name");
        String lastName = scanner.next();
        contact.setLastName(lastName);
        System.out.println("Please enter the phone number");
        String phoneNumber = scanner.next();
        contact.setPhoneNumber(phoneNumber);
        System.out.println("Please enter the email");
        String email = scanner.next();
        contact.setEmail(email);
        System.out.println("Please enter the contact type");
        String contactType = scanner.next();
        contact.setContactType(contactType);
        System.out.println("Now create the Address");
        Address address = new Address();
        System.out.println("Please enter the country");
        address.setCountry(scanner.next());
        System.out.println("Please enter the city");
        address.setCity(scanner.next());
        System.out.println("Please enter the street");
        address.setStreet(scanner.next());
        System.out.println("Please enter the apartment");
        address.setApartment(scanner.next());
        contact.setAddress(address);
        return contact;
    }
}
