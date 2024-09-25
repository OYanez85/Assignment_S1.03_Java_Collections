import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a HashMap to store countries and their capitals
        HashMap<String, String> countriesMap = new HashMap<>();

        // Step 2: Read the countries.txt file and fill the HashMap
        try (BufferedReader reader = new BufferedReader(new FileReader("countries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String country = parts[0].trim();
                    String capital = parts[1].trim();
                    countriesMap.put(country, capital);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Step 3: Ask for the user's name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        // Step 4: Initialize score and prepare for the quiz
        int score = 0;
        List<String> countriesList = new ArrayList<>(countriesMap.keySet());
        Random random = new Random();

        // Step 5: Ask for the capital of 10 random countries
        for (int i = 0; i < 10; i++) {
            // Select a random country
            String randomCountry = countriesList.get(random.nextInt(countriesList.size()));

            // Ask the user for the capital of the selected country
            System.out.print("What is the capital of " + randomCountry + "? ");
            String userAnswer = scanner.nextLine().trim();

            // Check if the answer is correct
            if (userAnswer.equalsIgnoreCase(countriesMap.get(randomCountry))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The capital of " + randomCountry + " is " + countriesMap.get(randomCountry));
            }
        }

        // Step 6: Save the user's name and score in classification.txt
        try (FileWriter writer = new FileWriter("classification.txt", true)) {
            writer.write(userName + ": " + score + "/10\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Step 7: Display final score
        System.out.println("Your final score: " + score + "/10");
        scanner.close();
    }
}
