import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Person {
    private String name;
    private String surname;
    private String dni;

    public Person(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s", name, surname, dni);
    }
}

public class Main {
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enter person.");
            System.out.println("2. Show people sorted by name (A-Z).");
            System.out.println("3. Show people sorted by name (Z-A).");
            System.out.println("4. Show people sorted by surname (A-Z).");
            System.out.println("5. Show people sorted by surname (Z-A).");
            System.out.println("6. Show people sorted by DNI (1-9).");
            System.out.println("7. Show people sorted by DNI (9-1).");
            System.out.println("0. Exit.");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (option) {
                case 1:
                    enterPerson(scanner);
                    break;
                case 2:
                    showPeopleSortedByName(true);
                    break;
                case 3:
                    showPeopleSortedByName(false);
                    break;
                case 4:
                    showPeopleSortedBySurname(true);
                    break;
                case 5:
                    showPeopleSortedBySurname(false);
                    break;
                case 6:
                    showPeopleSortedByDni(true);
                    break;
                case 7:
                    showPeopleSortedByDni(false);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    private static void enterPerson(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter DNI: ");
        String dni = scanner.nextLine();

        people.add(new Person(name, surname, dni));
    }

    private static void showPeopleSortedByName(boolean ascending) {
        List<Person> sortedList = new ArrayList<>(people);
        sortedList.sort(Comparator.comparing(Person::getName));
        if (!ascending) {
            Collections.reverse(sortedList);
        }
        displayPeople(sortedList);
    }

    private static void showPeopleSortedBySurname(boolean ascending) {
        List<Person> sortedList = new ArrayList<>(people);
        sortedList.sort(Comparator.comparing(Person::getSurname));
        if (!ascending) {
            Collections.reverse(sortedList);
        }
        displayPeople(sortedList);
    }

    private static void showPeopleSortedByDni(boolean ascending) {
        List<Person> sortedList = new ArrayList<>(people);
        sortedList.sort(Comparator.comparing(Person::getDni));
        if (!ascending) {
            Collections.reverse(sortedList);
        }
        displayPeople(sortedList);
    }

    private static void displayPeople(List<Person> list) {
        System.out.println("\n___Name___ ____Surnames___ __DNI__");
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
