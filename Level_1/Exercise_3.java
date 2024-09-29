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
        
        HashMap<String, String> countriesMap = new HashMap<>();

        
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

        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        
        int score = 0;
        List<String> countriesList = new ArrayList<>(countriesMap.keySet());
        Random random = new Random();

        
        for (int i = 0; i < 10; i++) {
            
            String randomCountry = countriesList.get(random.nextInt(countriesList.size()));

            
            System.out.print("What is the capital of " + randomCountry + "? ");
            String userAnswer = scanner.nextLine().trim();

            
            if (userAnswer.equalsIgnoreCase(countriesMap.get(randomCountry))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The capital of " + randomCountry + " is " + countriesMap.get(randomCountry));
            }
        }

        
        try (FileWriter writer = new FileWriter("classification.txt", true)) {
            writer.write(userName + ": " + score + "/10\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        
        System.out.println("Your final score: " + score + "/10");
        scanner.close();
    }
}
