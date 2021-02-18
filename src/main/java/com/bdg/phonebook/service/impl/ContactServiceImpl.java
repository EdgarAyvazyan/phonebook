package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Address;
import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.service.ContactService;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the first name");
            String firstName = scanner.next();
            System.out.println("Please enter the last name");
            String lastName = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstName) &&
                        contact.getLastName().equals(lastName)) {
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
        Contact result = new Contact();
        if (contacts != null) {
            //TODO you have to fetch firstName,lastName,phoneNumber,email for getting contact.
            // Like
            // Contact result = null;
            //        if (contact != null && contacts != null) {
            //            for (Contact con : contacts) {
            //                if (con.getFirstName().equals(contact.getFirstName()) && con.getLastName().equals(contact.getLastName())
            //                        && con.getPhoneNumber().equals(contact.getPhoneNumber()) && con.getEmail().equals(contact.getEmail())) {
            //                    result = con;
            //                }
            //            }
            //        }
            System.out.println("Please enter the contact");
            String getContact = scanner.next();
            System.out.println("Please enter the First name");
            String firstName = scanner.next();
            for (Contact type : contacts) {
                if (type.getContactType().equals(getContact) && contact.getFirstName().equals(firstName)) {
                    result = type;
                }
            }
        }
        return result;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        if (contacts != null) {
            Contact contact = createContact();
            contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {

//        TODO you dont have to write try catch block, for deleting contact
//         you need find it by get contact method. User have to enter firstName,lastName,phoneNumber, email.
//         See getContact method comment
        try {
            System.out.println("phone number");
            String number = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber().equals(number)) {
                    contacts.remove(contact);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @Override
    public Contact editContact(Set<Contact> contacts) {
        Contact editedContact = null;
        if (contacts != null) {
            Contact contact = new Contact();
            System.out.println("First name");
            contact.setFirstName(scanner.next());
            System.out.println("Last name");
            contact.setLastName(scanner.next());
            System.out.println("Phone number");
            contact.setPhoneNumber(scanner.next());
            Contact contactEdit = getContact(contact, contacts);
            Contact newContact = createContact();
            editedContact = updatedContactToContact(contactEdit, newContact);
        }
        return editedContact;
    }


    @Override
    public void getAllContacts(Set<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("The contact list is empty");
        } else {
            contacts.forEach(System.out::println);
        }
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        if (contacts != null) {
            System.out.println("Enter contacts ID");
            int contactId = scanner.nextInt();
            for (Contact contact : contacts) {
                if (contact.getId() == contactId) {
                    contacts.remove(contact);
                    return true;
                }
            }
        }
        return false;
    }
//    TODO you have to update all fields in contact.
    private static Contact updatedContactToContact(Contact source, Contact destination) {
        source.setFirstName(destination.getFirstName());
        source.setLastName(destination.getFirstName());
        source.setPhoneNumber(destination.getPhoneNumber());
        return source;
    }

    public static Contact createContact() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        Address address = new Address();
        System.out.println("Enter contacts first name");
        contact.setFirstName(scanner.next());
        System.out.println("Enter contacts last name");
        contact.setLastName(scanner.next());
        System.out.println("Enter contacts phone number(+374 ))");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Enter contacts email");
        contact.setEmail(scanner.next());
//      TODO for initialize contact type you have to declare  switch block with values 1,2,3
//       int contactType = scanner.nextInt();
//        switch (contactType) {
//            case 1: {
//                contact.setContactType(ContactTypeEnum.MOBILE.getName());
//                break;
//            }
//            case 2: {
//                contact.setContactType(ContactTypeEnum.HOME.getName());
//                break;
//            }
//            case 3: {
//                contact.setContactType(ContactTypeEnum.WORK.getName());
//                break;
//            }
//        }
        System.out.println("Enter contact type in number (1 for Mobile, 2 for Home, 3 for Work)");
        contact.setContactType(scanner.next());
        System.out.println("Enter contact address");
        System.out.println("Enter the country");
        address.setCountry(scanner.next());
        System.out.println("Enter the city");
        address.setCity(scanner.next());
        System.out.println("Enter the street");
        address.setStreet(scanner.next());
        System.out.println("Enter the building");
        address.setBuilding(scanner.next());
        System.out.println("Enter the apartment");
        address.setApartment(scanner.next());
        contact.setAddress(address);

        return contact;
    }
}

