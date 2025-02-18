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

