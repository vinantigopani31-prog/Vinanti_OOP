package pr3 ;
import java.util.* ;
public class pr2{
    public static boolean ValidPassword(String password){
        int count = 0 ;
        if(password.length() < 8)
            return false;
        int flag = 0 ;
        for(int i = 0 ; i < password.length(); i++){
            
            char ch = password.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <='9')){
                flag = 1 ;
            }
            if(ch >= '0' && ch <='9'){
                count++;
            }
        }
        if(count >= 2 && flag == 1){
            return true ;
        }
        return false ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Enter a password you want to create: ");
        String password = sc.next() ;
        if(ValidPassword(password)){
            System.out.println("Valid Password");
        }
        else{
            System.out.println("Invalid Password");
        }  
    }
}