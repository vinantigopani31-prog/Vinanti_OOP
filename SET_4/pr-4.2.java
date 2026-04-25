import java.util.*;
class Payment{
    void processPayment(int amount){
        System.out.println("Processing Payment of Rs. " + amount);
    }
}
class CreditCardPayment extends Payment {
    void processPayment(int amount) {
        System.out.println("Payment of Rs. " + amount + " done using Credit Card.");
    }
}
class UPIPayment extends Payment {
    void processPayment(int amount){
         System.out.println("Payment of Rs. " + amount + " done using UPI.");
    }
}
public class pr-4.2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an amount : ");
    int amount = sc.nextInt();

    System.out.println("Select Payment Method : ");
    System.out.println("press 1 for payment done using Creafit Card.");
    System.out.println("Prees 2 for Payment fone using UPI.");
    System.out.println("Enter yout choice : ");
    int choice = sc.nextInt();
    CreditCardPayment c = new CreditCardPayment();
    UPIPayment u = new UPIPayment() ;

    switch (choice) {
        case 1 :
            c.processPayment(amount);
            break;
        case 2 :
            u.processPayment(amount);
            break;
        default:
            System.out.println("Enter valid choice");
            break;
    }
    sc.close();
  }  
}