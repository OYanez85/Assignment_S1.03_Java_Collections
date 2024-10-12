package Level_3.Exercise_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_6 {
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Load data from CSV file at the beginning
        loadPeopleFromCSV("people.csv");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add a person.");
            System.out.println("2. Display people sorted by name (A-Z).");
            System.out.println("3. Display people sorted by name (Z-A).");
            System.out.println("4. Display people sorted by surname (A-Z).");
            System.out.println("5. Display people sorted by surname (Z-A).");
            System.out.println("6. Display people sorted by ID (1-9).");
            System.out.println("7. Display people sorted by ID (9-1).");
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

    // Method to add a new person manually
    private static void enterPerson(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter DNI: ");
        String dni = scanner.nextLine();

        people.add(new Person(name, surname, dni));
    }

    // Method to load people from a CSV file
    private static void loadPeopleFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 3) {
                    people.add(new Person(values[0].trim(), values[1].trim(), values[2].trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    // Sorting methods for people by name, surname, and DNI
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

    // Method to display people
    private static void displayPeople(List<Person> list) {
        System.out.println("\n___Name___   ____Surname___   __ID__");
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
