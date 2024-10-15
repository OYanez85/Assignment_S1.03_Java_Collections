package Level_3.Exercise_1;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Main {
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Load people from the CSV file hosted online
        loadPeopleFromCSV("https://raw.githubusercontent.com/OYanez85/Assignment_S1.03_Java_Collections/main/Level_3/Exercise_1/people.csv");

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
            scanner.nextLine(); // Consume newline

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
        String name, surname, dni;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            }
        } while (name.isEmpty());

        do {
            System.out.print("Enter surname: ");
            surname = scanner.nextLine().trim();
            if (surname.isEmpty()) {
                System.out.println("Surname cannot be empty.");
            }
        } while (surname.isEmpty());

        do {
            System.out.print("Enter DNI: ");
            dni = scanner.nextLine().trim();
            if (!dni.matches("\\d{8}[A-Za-z]")) {
                System.out.println("Invalid DNI format. It must be 8 digits followed by a letter.");
            }
        } while (!dni.matches("\\d{8}[A-Za-z]"));
        people.add(new Person(name, surname, dni));
    }

    private static void loadPeopleFromCSV(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    if (values.length == 3) {
                        people.add(new Person(values[0].trim(), values[1].trim(), values[2].trim()));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
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
        System.out.printf("\n%-10s %-20s %-10s%n", "Name", "Surname", "ID");
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
