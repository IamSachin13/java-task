package task4;

// Define the custom exception class for invalid voter age
class InvalidVoterAgeException extends Exception {
    public InvalidVoterAgeException(String message) {
        super(message);
    }
}

// Define the Voter class
class Voter {
    private int voterId;
    private String name;
    private int age;

    // Parameterized constructor
    public Voter(int voterId, String name, int age) throws InvalidVoterAgeException {
        if (age < 18) {
            throw new InvalidVoterAgeException("invalid age for voter");
        }
        this.voterId = voterId;
        this.name = name;
        this.age = age;
    }

    // Getters for Voter attributes
    public int getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Display Voter details
    public void display() {
        System.out.println("Voter ID: " + voterId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Main class to test the Voter class
public class task4b {
    public static void main(String[] args) {
        try {
            // This voter will be created successfully
            Voter voter1 = new Voter(101, "Alice", 30);
            voter1.display();

            // This will throw InvalidVoterAgeException
            Voter voter2 = new Voter(102, "Bob", 16);
            voter2.display();

        } catch (InvalidVoterAgeException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
