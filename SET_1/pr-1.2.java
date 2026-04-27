import java.util.*;
public class pr-1.2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number :");
        int num = sc.nextInt();
        int result = 0 ; 
        int palce = 1 ;
        while(num > 0)
        {
            int digit = num % 10 ;
            digit = (digit+ 1) % 10 ;
            result += digit * palce ;
            palce *= 10 ;
            num /= 10 ;
        }
        System.out.println("Result after adding one to each digit : " + result);
        sc.close();
    }
}