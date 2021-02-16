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
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the first name of contact");
            String firstName = scanner.next();
            System.out.println("Please enter the last name of contact");
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
        Contact result = null;
        if (contact != null && contacts != null) {
            for (Contact con : contacts) {
                if (con.getFirstName().equals(contact.getFirstName()) &&
                        con.getLastName().equals(contact.getLastName()) &&
                        con.getPhoneNumber().equals(contact.getPhoneNumber()) &&
                        con.getEmail().equals(contact.getEmail())) {
                    result = contact;
                }
            }
        }

        return result;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        if (contacts != null) {
            final Contact contact = createContact();
            contacts.add(contact);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
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
            contacts.remove(getContact(contact,contacts));
            return true;
        }

        return false;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        Contact editedContact = null;
        if (contacts != null) {
            Contact contact = new Contact();
            System.out.println("For editing contact enter:");
            System.out.println("Enter contact first name");
            contact.setFirstName(scanner.next());
            System.out.println("Enter contact last Name");
            contact.setLastName(scanner.next());
            System.out.println("Enter contact phone number");
            contact.setPhoneNumber(scanner.next());
            System.out.println("Enter contact email");
            contact.setEmail(scanner.next());
            Contact contactToEdit = getContact(contact,contacts);
            Contact newContact = createContact();
            editedContact = updatedContactToContact(contactToEdit,newContact);
        }

        return editedContact;
    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("The contact list is empty");
        }
        else {
            contacts.forEach(System.out::println);
        }
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        if (contacts != null) {
            System.out.println("For deleting contact  enter contact ID");
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

    private static Contact updatedContactToContact(Contact source, Contact destination) {
        destination.setFirstName(source.getFirstName());
        destination.setLastName(source.getLastName());
        destination.setPhoneNumber(source.getPhoneNumber());
        destination.setEmail(source.getEmail());
        destination.setContactType(source.getContactType());
        destination.setAddress(source.getAddress());

        return destination;
    }

    public static Contact createContact() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("please enter first name");
        contact.setFirstName(scanner.next());
        System.out.println("Please enter last name");
        contact.setLastName(scanner.next());
        System.out.println("please enter phone number(+374(code)******)");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Please enter email");
        contact.setEmail(scanner.next());
        System.out.println("Please enter contact in type(1 for Mobile, 2 for Home, 3 for Work)");
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
        contact.setAddress(address);

        return contact;
    }
}
