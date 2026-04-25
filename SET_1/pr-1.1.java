import java.util.*;
public class pr-1.1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        int amount = sc.nextInt();
        int note100 = 0, note50 = 0, note5 = 0 ,note2 = 0, note10 = 0 , note1 = 0 ;
        if(amount <= 0){
            System.out.println("Invalid input ! Try again");
        }
        else{

            if(amount >= 100){
                note100 = amount / 100 ;
                amount = amount % 100 ;
            }
            if(amount >= 50){
                note50 = amount / 50 ;
                 amount = amount % 50 ;
            }
            if(amount >= 10){
                note10 = amount / 10 ;
                amount = amount % 10 ;
            }
            if(amount >= 5){
                note5 = amount / 5 ;
                amount = amount % 5 ;
            }
            if(amount >= 2){
                note2 = amount / 2 ;
                amount = amount % 2 ;
            }
            if(amount >= 1){
                note1 = amount ;
            }
            System.out.println("Minimum number of notes : ");
            System.out.println("Number of 100 notes: " + note100);
            System.out.println("Number of 50 notes: " + note50);
            System.out.println("Number of 10 notes: " + note10);
            System.out.println("Number of 5 notes: " + note5);
            System.out.println("Number of 2 notes: " + note2);
            System.out.println("Number of 1 notes: " + note1);
            sc.close();
        }
    }
}