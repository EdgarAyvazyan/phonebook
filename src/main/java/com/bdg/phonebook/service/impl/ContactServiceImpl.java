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
                if (contact.getPhoneNumber(scanner.next()).equals(phoneNumber)) {
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
            System.out.println("Please enter the contact");
            String getContact = scanner.next();
            System.out.println("Please enter the First name");
            String firstName = scanner.next();
            for (Contact type : contacts) {
                if (type.getContactType().equals(getContact) && contact.getFirstName().equals(firstName))  {
                    result = type;
                }
            }
        }
        return result;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        try {
            Contact contact = new Contact();
            Address address = new Address();

            System.out.println("Please enter the name");
            contact.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            contact.setLastName(scanner.next());
            System.out.println("Please enter the phone number (+374(code)********)");
            contact.setPhoneNumber(scanner.next());
            System.out.println("Please enter email");
            contact.setEmail(scanner.next());
            System.out.println("Please enter contact type number (1 for Mobile, 2 for Home, 3 for Work))");
            contact.setContactType(scanner.next());
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

            contacts.add(contact);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }


    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        try{
            System.out.println("phone number");
            String number = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber(scanner.next()).equals(number)) {
                    contacts.remove(contact);
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
            System.out.println("Please enter the first name");
            String firstName = scanner.next();
            System.out.println("Please enter the last name");
            String lastName = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstName) &&
                        contact.getLastName().equals(lastName)) {
                }
            }
            return null;
        }



    @Override
    public void getAllContacts(Set<Contact> contacts) {

        if(contacts.isEmpty()) {
            System.out.println("The contact list is empty");
        } else {
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
