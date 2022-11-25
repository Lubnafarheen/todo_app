package se.lexicon;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.Role;
import se.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {

    public MainMenu displayMenu() {
        System.out.println("### Welcome to Todo App");
        System.out.println("Select from the list below what operation you would like to perform:");
        System.out.println("1. Register \n" +
                "2. Create a Task \n" +
                "3. Display all tasks \n" +
                "4.Exit");
        int operationCode = getNumber();
        switch (operationCode) {
            case 1:
                return MainMenu.REGISTER;
            case 2:
                return MainMenu.CREATE_TASK;
            case 3:
                return MainMenu.DISPLAY_TASKS;
            default:
                return MainMenu.EXIT;
        }
    }

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Person getpersonData() {
        System.out.println("Enter a Username");
        String username = getString();

        System.out.println("Create a Password with minimum 8 characters length");
        String password = getString();

        AppUser appUserData = new AppUser(username, password, Role.ROLE_USER);

        System.out.println("Enter your Firstname");
        String firstName = getString();

        System.out.println("Enter your Lastname");
        String lastName = getString();

        Person personData = new Person(firstName, lastName, appUserData);

        return personData;
    }

    public void displayPersonInformation(Person person) {
        System.out.println(person.toString());
    }

    public TodoItem getTodoItemData() {
        System.out.println("Enter a Title");
        String title = getString();

        System.out.println("Enter a description for your task");
        String description = getString();

        System.out.println("Set a deadline");
        int deadline = getNumber();
        return null;
    }

}


