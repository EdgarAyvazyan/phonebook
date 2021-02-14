package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.enums.ContactTypeEnum;
import com.bdg.phonebook.service.ContactService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if(contacts != null) {
            System.out.println("PLease insert first name");
            String firstName = scanner.next();
            System.out.println("Please insert last name");
            String lastName = scanner.next();
            for (Contact contact : contacts) {
                if(contact.getFirstName().equals(firstName) &&
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
        if(contacts != null) {
            System.out.println("Please insert phoneNumber");
            String phoneNumber = (scanner.next());
            for (Contact contact : contacts) {
                if(contact.getPhoneNumber().equals(phoneNumber)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        Contact result = new Contact();
        System.out.println("Please insert first name");
        String firstName = scanner.next();
        System.out.println("Please insert last name");
        String lastName = scanner.next();
        System.out.println("Please insert id");
        int id = Integer.parseInt(scanner.next());
        System.out.println("Please insert email");
        String email = scanner.next();
        System.out.println("Please insert address");
        String address = scanner.next();
        for (Contact contactItem : contacts) {
            if(contactItem.getFirstName().equals(firstName) &&
                    contactItem.getLastName().equals(lastName) &&
                    contactItem.getEmail().equals(email) &&
                    contactItem.getEmail().equals(email) &&
                    contactItem.getId() == id &&
                    contactItem.getAddress().equals(address)
            ) {
                result = contactItem;
            }
        }
        return result;
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
        //TODO
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
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Please insert first name");
        contact.setFirstName(scanner.next());
        System.out.println("Please insert last name");
        contact.setLastName(scanner.next());
        System.out.println("Please insert email");
        contact.setEmail(scanner.next());
        System.out.println("Please insert contact type 1-mobile 2-home 3-work");
        int contactType = scanner.nextInt();
        switch (contactType) {
            case 1: {
                contact.setContactType(ContactTypeEnum.MOBILE.getName());
                break;
            }
            case 2: {
                contact.setContactType(ContactTypeEnum.HOME.getName());
                break;
            }
            case 3: {
                contact.setContactType(ContactTypeEnum.WORK.getName());
                break;
            }
        }
        System.out.println("Please insert address");
        String address = scanner.next();
        return null;
    }
}
