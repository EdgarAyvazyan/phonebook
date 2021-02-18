package com.bdg.phonebook.service.impl;

import com.bdg.phonebook.domain.Address;
import com.bdg.phonebook.domain.Contact;
import com.bdg.phonebook.enums.ContactTypeEnum;
import com.bdg.phonebook.service.ContactService;

import java.sql.SQLOutput;
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
            System.out.println("Please enter the first name of the contact");
            String firstname = scanner.next();
            System.out.println("Please enter the last name of the contact");
            String lastname = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstname) && contact.getLastName().equals(lastname)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Contact> getByPhoneNumber(Set<Contact> contacts) {
        //TODO
        Set<Contact> contactNumb = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter the phone number of the contact");
            String phoneNumber = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    contactNumb.add(contact);
                }
            }
        }
        return contactNumb;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            for (Contact contactGet  : contacts) {
                if (contact.getFirstName().equals(contactGet.getFirstName()) &&
                        contact.getLastName().equals(contactGet.getLastName()) &&
                        contact.getPhoneNumber().equals(contactGet.getPhoneNumber()) &&
                        contact.getEmail().equals(contactGet.getEmail())) {
                    return contactGet;
                }
            }
        }
        return null;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            Contact contact = createContact();
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
            Contact contactDel = new Contact();
            System.out.println("Please enter the first name you want to delete");
            contactDel.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            contactDel.setLastName(scanner.next());
            System.out.println("Please enter the phone number");
            contactDel.setPhoneNumber(scanner.next());
            System.out.println("Please enter the email");
            contactDel.setEmail(scanner.next());
            Contact contact1 = getContact(contactDel, contacts);
            contacts.remove(contact1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Contact editContact(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            Contact contactToEdit = new Contact();
            System.out.println("Please enter the first name you want to edit");
            contactToEdit.setFirstName(scanner.next());
            System.out.println("Please enter the last name");
            contactToEdit.setLastName(scanner.next());
            System.out.println("Please enter the phone number");
            contactToEdit.setPhoneNumber(scanner.next());
            System.out.println("Please enter the email");
            contactToEdit.setEmail(scanner.next());
            Contact contactEdited = getContact(contactToEdit, contacts);
            System.out.println("Please choose which field you want to edit in contact beyond");
            System.out.println(contactEdited);
            System.out.println("1 for First name, 2 for last name, 3 for phone number, " +
                               "4 for email, 5 for contact type, 6 for address");
            int fieldNum = scanner.nextInt();
            switch (fieldNum) {
                case 1: {
                    System.out.println("enter new first name");
                    contactEdited.setFirstName(scanner.next());
                    break;
                }
                case 2: {
                    System.out.println("enter new last name");
                    contactEdited.setLastName(scanner.next());
                    break;
                }
                case 3: {
                    System.out.println("enter new phone number");
                    contactEdited.setPhoneNumber(scanner.next());
                    break;
                }
                case 4: {
                    System.out.println("enter new email");
                    contactEdited.setEmail(scanner.next());
                    break;
                }
                case 5: {
                    System.out.println("enter new contact type");
                    System.out.println("1 for Mobile, 2 for Home, 3 for work ");
                    int contactTypeNew = scanner.nextInt();
                    switch (contactTypeNew) {
                        case 1: {
                            contactEdited.setContactType(ContactTypeEnum.MOBILE.getName());
                            break;
                        }
                        case 2: {
                            contactEdited.setContactType(ContactTypeEnum.HOME.getName());
                            break;
                        }
                        case 3: {
                            contactEdited.setContactType(ContactTypeEnum.WORK.getName());
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    Address addressNew = new Address();
                    System.out.println("Please enter your country");
                    addressNew.setCountry(scanner.next());
                    System.out.println("Please enter your city");
                    addressNew.setCity(scanner.next());
                    System.out.println("Please enter the street");
                    addressNew.setStreet(scanner.next());
                    System.out.println("PLease enter the building");
                    addressNew.setBuilding(scanner.next());
                    System.out.println("Please enter the apartment");
                    addressNew.setApartment(scanner.next());
                    contactEdited.setAddress(addressNew);
                    break;
                }
                default: {
                    System.out.println("You entered wrong command");
                }
            }

            System.out.println(contactEdited);
            return contactEdited;
        } else {
        return null;
        }
    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        //TODO

        if (contacts.isEmpty()) {
            System.out.println("contact list is empty");
            } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        //TODO
        if (contacts != null) {
            System.out.println("Please enter a contact Id  you want to delete");
            int contactId = scanner.nextInt();
            for (Contact contactDelId : contacts) {
                if (contactDelId.getId() == contactId) {
                    contacts.remove(contactDelId);
                    System.out.println("You have successfully deleted the contact");
                    return true;
                }
            }
        }

        return false;
    }

//    private static Contact updatedContactToContact(Contact source, Contact destination) {
//        //TODO
//
//
//        return null;
//    }

    public static Contact createContact() {
        //TODO
        Contact contact = new Contact();
        Address address = new Address();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first name");
        contact.setFirstName(scanner.next());
        System.out.println("Please enter the last name");
        contact.setLastName(scanner.next());
        System.out.println("Please enter the phone number");
        contact.setPhoneNumber(scanner.next());
        System.out.println("Please enter the email");
        contact.setEmail(scanner.next());
        System.out.println("Please enter the contact type");
        System.out.println("1 for Mobile, 2 for Home, 3 for work ");
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
        System.out.println("Please enter your country");
        address.setCountry(scanner.next());
        System.out.println("Please enter your city");
        address.setCity(scanner.next());
        System.out.println("Please enter the street");
        address.setStreet(scanner.next());
        System.out.println("PLease enter the building");
        address.setBuilding(scanner.next());
        System.out.println("Please enter the apartment");
        address.setApartment(scanner.next());
        contact.setAddress(address);
        return contact;
    }
}
