//EASY
import java.util.Scanner;
public class Exp3E{
public static void main(String[] args) {
    System.out.println("Enter a Number: ");
    Scanner sc = new Scanner(System.in);
    int number= sc.nextInt();
    try{
        if(number<0)
            throw new ArithmeticException("Cannot calculate the square root of a negative number");
        else
            System.out.println("Square root of "+number+" is "+Math.sqrt(number));
    }
    catch(ArithmeticException e){
        System.out.println(e);
    }
    catch(IllegalArgumentException e){
        System.out.println(e);
    }
    sc.close();

}
}

//MEDIUM
import java.util.Scanner;
public class Exp3M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctPin = 1307;
        double balance = 3000;

        try {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            
            if (pin != correctPin) {
                throw new Exception("Error: Invalid PIN.");
            }
            
            System.out.print("Withdraw Amount: ");
            double amount = scanner.nextDouble();
            
            if (amount > balance) {
                throw new Exception("Error: Insufficient balance.");
            }
            
            balance -= amount;
            System.out.println("Withdrawal successful. Withdrawn: " + amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Current Balance: " + balance);
            scanner.close();
        }
    } }

//HARD
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int maxEnrollment;
    private int currentEnrollment;
    private String prerequisite;

    public Course(String name, int maxEnrollment, String prerequisite) {
        this.name = name;
        this.maxEnrollment = maxEnrollment;
        this.currentEnrollment = 0;
        this.prerequisite = prerequisite;
    }

    public String getName() {
        return name;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void enroll() throws CourseFullException {
        if (currentEnrollment >= maxEnrollment) {
            throw new CourseFullException("The course " + name + " is already full.");
        }
        currentEnrollment++;
    }
}

class Student {
    private String name;
    private boolean hasCompletedPrerequisite;

    public Student(String name, boolean hasCompletedPrerequisite) {
        this.name = name;
        this.hasCompletedPrerequisite = hasCompletedPrerequisite;
    }

    public String getName() {
        return name;
    }

    public boolean hasCompletedPrerequisite() {
        return hasCompletedPrerequisite;
    }

    public void enrollInCourse(Course course) throws PrerequisiteNotMetException, CourseFullException {
        if (!hasCompletedPrerequisite && course.getPrerequisite() != null) {
            throw new PrerequisiteNotMetException("Complete " + course.getPrerequisite() + " before enrolling in " + course.getName());
        }
        course.enroll();
        System.out.println(name + " has been successfully enrolled in " + course.getName());
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Course coreJava = new Course("Core Java", 2, null);
        Course advancedJava = new Course("Advanced Java", 2, "Core Java");

        Student student1 = new Student("Charanjeet", false);
        Student student2 = new Student("Atul", true);

        try {
            student1.enrollInCourse(advancedJava);
        } catch (PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            student2.enrollInCourse(advancedJava);
        } catch (PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            student1.enrollInCourse(coreJava);
            student2.enrollInCourse(coreJava);
        } catch (PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

