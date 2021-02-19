package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Address;
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
        //TODO
        Set<Contact> result = new HashSet<>();
        if (contacts !=null) {
            System.out.println("Please enter first name of contact");
            String firstName = scanner.next();
            System.out.println("Please enter last name of contact");
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
        //TODO
        Set<Contact> contactSet = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter  phone number of contact");
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
        Contact result = null;
        if (contact != null && contacts != null) {
            for (Contact con : contacts) {
                if (con.getFirstName().equals(contact.getFirstName()) && con.getLastName().equals(contact.getLastName()) &&
                        con.getPhoneNumber().equals(contact.getPhoneNumber()) && con.getEmail().equals(contact.getEmail())) {
                    result = con;
                }
            }
        }

        return result;

    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            final Contact contact = createContact();
            contacts.add(contact);
            Address address = new Address();

            System.out.println("Please enter first name");
            String firstName = scanner.next();
            newContact.setFirstName(firstName);

            System.out.println("Please enter last name");
            String lastName = scanner.next();
            newContact.setLastName(lastName);

            System.out.println("Please enter email");
            String email = scanner.next();
            newContact.setEmail(email);

            System.out.println("Please enter phone number");
            String phoneNumber = scanner.next();
            newContact.setPhoneNumber(phoneNumber);

            System.out.println("Please enter contactType");
            String contactType = scanner.next();
            newContact.setContactType(contactType);


            System.out.println("Please enter address");
            String Address = scanner.next();
            newContact.setAddress(address);

            System.out.println("Please enter country");
            String country = scanner.next();
            address.setCountry(country);

            System.out.println("Please enter city");
            String city = scanner.next();
            address.setCity(city);

            System.out.println("Please enter building");
            String building = scanner.next();
            address.setBuilding(building);

            System.out.println("Please enter apartment");
            String apartment = scanner.next();
            address.setApartment(apartment);

            System.out.println("Please enter street");
            String street = scanner.next();
            address.setStreet(street);

            newContact.setAddress(address);
            return true;
        } else {
        }
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            Contact contact = new Contact();
            System.out.println("For deleting contact please enter");
            System.out.println("Please enter the first name");
            contact.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            contact.setLastName(scanner.next());
            System.out.println("Please enter an email");
            contact.setEmail(scanner.next());
            System.out.println("Please enter phone number");
            contact.setPhoneNumber(scanner.next());
            contacts.remove(getContact(contact, contacts));
        }
        return false;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        //TODO
        Contact edited = null;
        if (contacts != null) {
            Contact contact = new Contact();
            System.out.println("Please enter editing contact");
            System.out.println("Please enter contact's  first name");
            contact.setFirstName(scanner.next());
            System.out.println("Please enter contact's last name");
            contact.setLastName(scanner.next());
            System.out.println("Please enter  contact's phone number");
            contact.setPhoneNumber(scanner.next());
            System.out.println("Please enter contact's email");
            contact.setEmail(scanner.next());
            Contact newContact = createContact();
            Contact contactEdit = getContact(contact, contacts);
            edited = updatedContactToContact(newContact, contactEdit);
        }
        return edited;
    }



    @Override
    public void getAllContacts(Set<Contact> contacts) {
        //TODO
        if (contacts.isEmpty()) {
            System.out.println();
        } else {

        }
        contacts.forEach(System.out::println);

    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            System.out.println("For deleting contact enter contact's ID");
            int contactID = scanner.nextInt();
            for (Contact contact : contacts) {
                if (contact.getID() == contactID) {
                    contacts.remove(contact);
                    return true;
                }

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
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Please enter the last name");
        contact.setLastName(scanner.next());
        System.out.println("Please enter the first name");
        contact.setFirstName(scanner.next());
        System.out.println("Please enter an email");
        contact.setEmail(scanner.next());
        System.out.println("Please enter phone number(098******)");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Please enter contact type in number (1 for Mobile,2 for Work,3 for Home)");
        int contactType = scanner.nextInt();
        switch (contactType) {
            case 1: {
                contact.setContactType(ContactTypeEnum.MOBILE.getName());
                break;
            }
            case 2: {
                contact.setContactType(ContactTypeEnum.WORK.getName());
                break;
            }
            case 3:
                contact.setContactType(ContactTypeEnum.HOME.getName());
                break;
        }
        Address address = new Address();
        System.out.println("Please enter contact address");
        System.out.println("Please enter the country");
        address.setCountry(scanner.next());
        System.out.println("Please enter the building");
        address.setBuilding(scanner.next());
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
