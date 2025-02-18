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

