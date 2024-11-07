package task4;


// Define the AgeNotWithinRangeException
class AgeNotWithinRangeException extends Exception {
    public AgeNotWithinRangeException(String message) {
        super(message);
    }
}

// Define the NameNotValidException
class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

// Define the Student class
class Student {
    private int rollNo;
    private String name;
    private int age;
    private String course;

    // Constructor with parameters
    public Student(int rollNo, String name, int age, String course) throws AgeNotWithinRangeException, NameNotValidException {
        if (age < 15 || age > 21) {
            throw new AgeNotWithinRangeException("Age not within the valid range of 15 to 21.");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new NameNotValidException("Name contains invalid characters.");
        }
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getters for Student attributes
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    // Display Student details
    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

// Main class to test the Student class
public class task4 {
    public static void main(String[] args) {
        try {
            Student student1 = new Student(101, "John", 20, "Computer Science");
            student1.display();

            // This will throw AgeNotWithinRangeException
            Student student2 = new Student(102, "Alice", 14, "Physics");
            student2.display();

        } catch (AgeNotWithinRangeException | NameNotValidException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        try {
            // This will throw NameNotValidException
            Student student3 = new Student(103, "J@ne", 18, "Mathematics");
            student3.display();

        } catch (AgeNotWithinRangeException | NameNotValidException e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }
}
