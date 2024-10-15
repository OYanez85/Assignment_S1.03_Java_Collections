package Level_1.Exercise_3;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class FileReadException extends Exception {
    public FileReadException(String message) {
        super(message);
    }
}

class InvalidLineException extends Exception {
    public InvalidLineException(String message) {
        super(message);
    }
}

class NoCountriesLoadedException extends Exception {
    public NoCountriesLoadedException(String message) {
        super(message);
    }
}

class FileWriteException extends Exception {
    public FileWriteException(String message) {
        super(message);
    }
}

public class Main_3 {

    private static final Logger logger = Logger.getLogger(Main_3.class.getName());

    public static void main(String[] args) throws FileReadException, InvalidLineException, NoCountriesLoadedException, FileWriteException {
        HashMap<String, String> countriesMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Level_1/Exercise_3/countries.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String country = parts[0].trim();
                    String capital = parts[1].trim();
                    countriesMap.put(country, capital);
                } else {
                    // Log the invalid line and skip it without throwing an exception
                    logger.log(Level.WARNING, "Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            throw new FileReadException("Error reading the file: " + e.getMessage());
        }

        if (countriesMap.size() == 0) {
            throw new NoCountriesLoadedException("No countries found in the file. Please check the file format.");
        }

        Scanner scanner = new Scanner(System.in);
        logger.log(Level.INFO, "Enter your name: ");
        String userName = scanner.nextLine();

        int score = 0;
        List<String> countriesList = new ArrayList<>(countriesMap.keySet());
        Random random = new Random();

        List<String> askedCountries = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String randomCountry;
            do {
                randomCountry = countriesList.get(random.nextInt(countriesList.size()));
            } while (askedCountries.contains(randomCountry));
            askedCountries.add(randomCountry);

            logger.log(Level.INFO, "What is the capital of {0}? ", randomCountry);
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(countriesMap.get(randomCountry))) {
                score++;
            } else {
                logger.log(Level.WARNING, "Incorrect! The capital of {0} is {1}", new Object[]{randomCountry, countriesMap.get(randomCountry)});
            }
        }

        try (FileWriter writer = new FileWriter("classification.txt", true)) {
            writer.write(userName + ": " + score + "/10\n");
        } catch (IOException e) {
            throw new FileWriteException("Error writing to file: " + e.getMessage());
        }

        logger.log(Level.INFO, "Your final score: {0}/10", score);
        scanner.close();
    }
}
