package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Address;
import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.enums.ContactTypeEnum;
import com.bdg.phonebook.service.ContactService;

import javax.sound.midi.SysexMessage;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;

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
    public Contact getContact(Set<Contact> contacts) {
        Contact result = new Contact();
        System.out.println("Please insert first name");
        String firstName = scanner.next();
        System.out.println("Please insert last name");
        String lastName = scanner.next();
        System.out.println("Please insert id");
        int id = scanner.nextInt();
        System.out.println("Please insert email");
        String email = scanner.next();
        for (Contact contactItem : contacts) {
            if(contactItem.getFirstName().equals(firstName) &&
                    contactItem.getLastName().equals(lastName) &&
                    contactItem.getEmail().equals(email) &&
                    contactItem.getId() == id
            ) {
                result = contactItem;
            }
        }
        return result;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        final Contact contact = createContact();
        if(contacts.add(contact)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        if(!contacts.isEmpty()) {
            System.out.println("Please insert first name");
            String firstName = scanner.next();
            System.out.println("Please insert last name");
            String lastName = scanner.next();
            System.out.println("Please insert id - only numbers");
            int id = 0;
            try {
                id = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please input integer number");
            }
            System.out.println("Please insert email");
            String email = scanner.next();
            System.out.println("Please insert phoneNumber");
            String phoneNumber = scanner.next();
            for (Contact contactItem : contacts) {
                if (contactItem.getFirstName().equals(firstName) &&
                        contactItem.getLastName().equals(lastName) &&
                        contactItem.getEmail().equals(email) &&
                        contactItem.getId() == id &&
                        contactItem.getPhoneNumber().equals(phoneNumber)
                ) {
                    contacts.remove(contactItem);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        Contact contact = new Contact();
        Address NewAddress = new Address();
        if(!contacts.isEmpty()) {
            contact = getContact(contacts);
            System.out.println("Please insert new first name");
            contact.setFirstName(scanner.next());
            System.out.println("Please insert new last name");
            contact.setLastName(scanner.next());
            System.out.println("Please insert new email");
            contact.setEmail(scanner.next());
            System.out.println("Please insert new phone book number");
            contact.setPhoneNumber(scanner.next());
        }
        return contact;
    }


    @Override
    public void getAllContacts(Set<Contact> contacts) {
        if(!contacts.isEmpty()) {
            for (Contact contactItem : contacts) {
                System.out.println(contactItem.getFirstName());
                System.out.println(contactItem.getLastName());
                System.out.println(contactItem.getPhoneNumber());
                System.out.println(contactItem.getEmail());
                System.out.println(contactItem.getId());
                System.out.println(contactItem.getContactType());
                System.out.println(contactItem.getAddress());
            }
        } else {
            System.out.println("Contact doesn't exist in Phonebook");
        }
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        if(!contacts.isEmpty()) {
            System.out.println("Please insert id");
            int id = scanner.nextInt();
            for (Contact contactItem : contacts) {
                if(contactItem.getId() == id) {
                    contacts.remove(contactItem);
                    return true;
                }
            }
        }
        return false;
    }

    private static Contact updatedContactToContact(Contact source, Contact destination) {
        destination = createContact();
        destination.setFirstName(source.getFirstName());
        destination.setLastName(source.getLastName());
        destination.setPhoneNumber(source.getPhoneNumber());
        destination.setEmail(source.getEmail());
        return destination;
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
            default: {
                System.out.println("You wrote invalid contact type");
            }
        }

        Address address = new Address();
        System.out.println("Please insert address");
        System.out.println("Please insert country");
        address.setCountry(scanner.next());
        System.out.println("Please insert city");
        address.setCity(scanner.next());
        System.out.println("Please insert street");
        address.setStreet(scanner.next());
        System.out.println("Please insert building");
        address.setBuilding(scanner.next());
        System.out.println("Please insert apartment");
        address.setApartment(scanner.next());
        contact.setAddress(address);
        return contact;
    }
}
