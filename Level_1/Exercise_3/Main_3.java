import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main_3 {
    public static void main(String[] args) {
        
        // HashMap to store country-capital pairs
        HashMap<String, String> countriesMap = new HashMap<>();

        // Reading countries.txt file and populating HashMap
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/oyanez85/Assignment_S1.03_Java_Collections/Level_1/Exercise_3/countries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Splitting by one or more spaces
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String country = parts[0].trim();
                    String capital = parts[1].trim();
                    countriesMap.put(country, capital);
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Debugging to print number of countries loaded
        System.out.println("Countries loaded: " + countriesMap.size());

        if (countriesMap.size() == 0) {
            System.out.println("No countries found in the file. Please check the file format.");
            return;
        }

        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Variables for score tracking
        int score = 0;
        List<String> countriesList = new ArrayList<>(countriesMap.keySet());
        Random random = new Random();

        // List to keep track of asked countries and ensure no repetition
        List<String> askedCountries = new ArrayList<>();

        // Ask 10 unique questions
        for (int i = 0; i < 10; i++) {
            String randomCountry;

            // Ensure a unique country is selected for each question
            do {
                randomCountry = countriesList.get(random.nextInt(countriesList.size()));
            } while (askedCountries.contains(randomCountry));  // Repeat until a unique country is selected

            // Add the country to the asked list
            askedCountries.add(randomCountry);

            // Ask the user for the capital of the random country
            System.out.print("What is the capital of " + randomCountry + "? ");
            String userAnswer = scanner.nextLine().trim();

            // Check if the user's answer is correct
            if (userAnswer.equalsIgnoreCase(countriesMap.get(randomCountry))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The capital of " + randomCountry + " is " + countriesMap.get(randomCountry));
            }
        }

        // Save the user's name and score to the classification.txt file
        try (FileWriter writer = new FileWriter("classification.txt", true)) {
            writer.write(userName + ": " + score + "/10\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Display the final score
        System.out.println("Your final score: " + score + "/10");
        scanner.close();
    }
}
