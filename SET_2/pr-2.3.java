package pr2 ;
import java.util.*;
class BillGenerator{
    void generateBill(int itemTotal){
        System.out.println("Customer is regular : ") ;
        System.out.println("Final amount : " + itemTotal);
    }
    void generateBill(int itemTotal , int discount) {
        System.out.println("Customer is privileged : ");
        int final_amount = itemTotal - discount ;
        System.out.println("Final amount : " + final_amount);
    }
    void generateBill(int itemTotal , double discount_persent){
        double discount = (itemTotal * discount_persent )/ 100 ;
        double final_amount = itemTotal - discount ;
        System.out.println("For festival offers :");
        System.out.println("Fianl amount : " + final_amount);
    }
}
public class pr-2.3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BillGenerator billgen = new BillGenerator() ;
        System.out.println("Read and follow below instruction.");
        System.out.println("==================================");
        System.out.println("press 1 if customer is regular.");
        System.out.println("Press 2 if Customer is privileged.");
        System.out.println("Press 3 if festival offer.");
        System.out.println("==================================");
        int itemTotal = 0 ;
        int choice ;
        do {
            System.out.print("Enter type of customer : ");
            choice = sc.nextInt() ;
            switch(choice) {
                case 1 :
                    System.out.println("Enetr a total amount : ");
                    itemTotal = sc.nextInt();
                    billgen.generateBill(itemTotal);
                    break ;
                case 2 :
                    System.out.println("Enetr a total amount : ");
                    itemTotal = sc.nextInt();
                    System.out.println("Enetr a discount in amount formate : ");
                    int discount = sc.nextInt();
                    billgen.generateBill(itemTotal, discount);
                    break ;
                case 3 :
                    System.out.println("Enetr a total amount : ");
                    itemTotal = sc.nextInt();
                    System.out.print("Enetr a discount in amount formate : ");
                    double discount_persent = sc.nextDouble();
                    billgen.generateBill(itemTotal, discount_persent);
                    break ;
                case 4 :
                    System.out.println("Exiting....");
                    break;
                default :
                    System.out.println("invalid customer type.");
                    break ;
            }
        } while (choice != 4);
        sc.close();
    }
}