package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.enums.ContactTypeEnum;
import com.bdg.phonebook.service.ContactService;
import com.bdg.phonebook.domain.Address;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the firstName");
            String firstName = scanner.next();
            System.out.println("Please enter the lastName");
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
            System.out.println("Please enter the phoneNumber");
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
        Contact result = null;
        if (contacts != null && contact != null) {
            for (Contact cont : contacts) {
                if (cont.getFirstName().equals(contact.getFirstName()) && cont.getLastName().equals(contact.getLastName())
                        && cont.getPhoneNumber().equals(contact.getPhoneNumber()) && cont.getEmail().equals(contact.getEmail())) {
                    result = cont;
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
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        if (contacts != null) {
            Contact cont = new Contact();
            System.out.println("For deleting contact please enter");
            System.out.println("Please enter the first name");
            cont.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            cont.setLastName(scanner.next());
            System.out.println("Please enter the phone number (+374(code)*******)");
            cont.setPhoneNumber(scanner.next());
            System.out.println("Please enter the email");
            cont.setEmail(scanner.next());
            contacts.remove(getContact(cont, contacts));
        }
        return true;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
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
            Contact newContacts = createContact();
            Contact contactEdit = getContact(contact, contacts);
            edited = updatedContactToContact(newContacts, contactEdit);
        }
        return edited;
    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("contacts isEmpty");
        } else {
            System.out.println("print contacts");
        }
        contacts.forEach(System.out::println);
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        if (contacts != null) {
            System.out.println("PLease enter deleting ID ");
            int contactId = scanner.nextInt();
            for (Contact cont : contacts) {
                if (cont.getId() == contactId) {
                    contacts.remove(cont);
                    System.out.println("Contact is deleted");
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
        System.out.println("Please enter first name, Name must be in range 2 - 50 symbols");
        contact.setFirstName(scanner.next());
        System.out.println("Please enter last name,Name must be in range 2 - 50 symbols");
        contact.setLastName(scanner.next());
        System.out.println("Please enter phone number (+374(code)******)");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Please enter contact type in number (1 for Mobile, 2 for Home, 3 for Work)");
        int contactType = scanner.nextInt();
        switch (contactType) {
            case 1: {
                contact.setContactType(ContactTypeEnum.MOBILE.getName());
            }
            case 2: {
                contact.setContactType(ContactTypeEnum.HOME.getName());
            }
            case 3:
                contact.setContactType(ContactTypeEnum.WORK.getName());
        }
        System.out.println("Please enter email");
        contact.setEmail(scanner.next());
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