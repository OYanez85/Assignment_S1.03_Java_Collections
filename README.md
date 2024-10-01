# S1.03_Java_Collections
Java_Collections

# S1.03_Java_Collections

## 📄 Description

This project consists of a series of Java exercises organized into three levels (Level 1, Level 2, and Level 3). The exercises demonstrate the use of collections in Java, with classes representing different types of objects and functionalities such as file management, iterator usage, and object sorting. The exercises are designed to reinforce concepts in object-oriented programming and the proper use of collections.

## 💻 Technologies Used

- **Java SE Development Kit (JDK)**: Version 22 or higher
- **Eclipse IDE or IntelliJ IDEA**: IDEs for writing and managing Java code
- **Git/GitHub**: For version control and repository management

## 📋 Requirements

- **Java SE Development Kit (JDK)**: Version 22 or higher installed on your local machine
- **Integrated Development Environment (IDE)**: Eclipse or IntelliJ IDEA
- **Git**: To clone the repository and manage version control

## 🛠️ Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/OYanez85/S1.03_Java_Collections.git
Open the project in IntelliJ IDEA or Eclipse:

For IntelliJ, navigate to File -> Open and select the cloned project directory.
For Eclipse, use File -> Import -> Git -> Projects from Git, then select the cloned directory.
Ensure that JDK 22 or higher is set up in your IDE:

In IntelliJ IDEA, go to File -> Project Structure -> Project SDK, and select JDK 22.
In Eclipse, go to Window -> Preferences -> Java -> Installed JREs, and ensure JDK 22 is set.

▶️ Execution
After opening the project, ensure the build is successful. To run a specific exercise, right-click the Main class of the corresponding exercise (e.g., MainExercici1.java) and select Run. You can also use the Run/Debug configuration to execute specific classes.

🌐 Deployment
This is a locally executed Java project, and no deployment on a server is required. However, if necessary, you can package the application using tools like Maven or Gradle to distribute it as a JAR file.

🤝 Contributions
Fork the repository on GitHub before making any changes.

Create a new branch for your changes:

git checkout -b feature/your-feature-name
After implementing your changes, commit them:

git add .
git commit -m "Your commit message"
Push the branch to your fork:

git push origin feature/your-feature-name
Open a pull request to merge your changes into the main repository.

📋 Level 1
Exercise 1: Create a class called Month with an attribute name. Add 11 Month objects (each with a different name) to an ArrayList, except for the object with the name "August". Insert it at the correct position and demonstrate that the ArrayList maintains the correct order.

Exercise 2: Create and populate a List<Integer>. Create a second List<Integer> and insert the elements of the first list in reverse order using a ListIterator.

Exercise 3: Create a program that reads the file countries.txt (found in the resources section) containing countries and capitals. The program should read the file and store the data in a HashMap<String, String>. The program asks for the user's name, then randomly selects a country from the HashMap and prompts the user to enter its capital. If the answer is correct, they earn a point. Repeat this 10 times, and after 10 questions, save the user's name and score in a file called classificacio.txt.

📋 Level 2
Exercise 1: Create a class called Restaurant with attributes name (String) and rating (int). Implement the necessary methods to prevent inserting Restaurant objects with the same name and rating into a HashSet.

Important: There can be restaurants with the same name and different ratings, but not with both the same name and rating.
Exercise 2: Using the class from the previous exercise, implement the necessary functionality to sort Restaurant objects by name and rating in descending order.

📋 Level 3
Exercise 1: Create an application capable of reading a CSV file containing three fields: name, surname, and DNI. Sort the people read from the file by name, surname, or DNI, as per the user's choice.

The Person class should have three attributes:

name
surname
DNI
The main class should have the following menu:

Add a person.
Show people sorted by name (A-Z).
Show people sorted by name (Z-A).
Show people sorted by surname (A-Z).
Show people sorted by surname (Z-A).
Show people sorted by DNI (1-9).
Show people sorted by DNI (9-1).
Exit.
The program should list the people as shown below:

___Name___ ____Surnames____ ____DNI____
Andreu          Ballestero         34835767J
Miquel          Bayona             48743957B
Guillem         Capdevila          33957834J
Albert          Carbonell          77364986R
Ferran          Casas              23047848P
Maria           Casellas           47102244S
Genis           Ciutat             39718459N