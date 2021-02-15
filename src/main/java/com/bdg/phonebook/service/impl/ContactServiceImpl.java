package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Address;
import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.enums.ContactTypeEnum;
import com.bdg.phonebook.service.ContactService;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        //TODO
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the first name of contact");
            String firstName = scanner.next();
            System.out.println("Please enter yhe last name of contact");
            String lastName = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstName) && (contact.getLastName().equals(lastName))) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Contact> getByPhoneNumber(Set<Contact> contacts) {
        //TODO
        Set<Contact> contactSet = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the phone number of contact");
            String phoneNumber = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    contactSet.add(contact);
                }
            }
        }

        return contactSet;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        //TODO

        return null;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            final Contact contact = createContact();
            contacts.add(contact);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            Contact contact = new Contact();
            System.out.println("For deleting contact please enter:");
            System.out.println("Please enter the first name");
            contact.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            contact.setLastName(scanner.next());
            System.out.println("Please enter the phone number(0********)");
            contact.setPhoneNumber(scanner.next());
            System.out.println("Please enter the email");
            contact.setEmail(scanner.next());
        }

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
        return destination;
    }

    public static Contact createContact() {
        //TODO
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Please enter first name");
        contact.setFirstName(scanner.next());
        System.out.println("Please enter last name");
        contact.setLastName(scanner.next());
        System.out.println("Please enter phone number (+374(code)******)");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Please enter email");
        contact.setEmail(scanner.next());
        System.out.println("Please enter contact type in number (1 for Mobile, 2 for Home, 3 for Work))");
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

        Address address = new Address();
        System.out.println("Please enter contact address");
        System.out.println("Please enter the country");
        address.setCountry(scanner.next());
        System.out.println("Please enter the city");
        address.setCity(scanner.next());
        System.out.println("Please enter the street");
        address.setStreet(scanner.next());
        System.out.println("Please enter the building");
        address.setBuilding(scanner.next());
        System.out.println("Please enter the apartment");
        address.setApartment(scanner.next());

        return null;
    }
}
