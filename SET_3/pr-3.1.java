package pr3 ;
import java.util.* ;
class university{
    static int totalstudent = 0  ;
    static String universityname ;
    static int gettotalstudent(){
        return totalstudent;
    }
    static {
        universityname = "GTU" ;
        totalstudent = 0;
        System.out.println("university name : " + universityname) ;
        System.out.println("Static block executed.");  
    }
    university(){
        totalstudent++ ;
    }
}
public class pr-3.1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in) ;
        
        
        System.out.println("==============MENU===================");
        System.out.println("press 1 for Create new object.");
        System.out.println("press 2 for Exit.");
        System.out.println("=====================================");
        
        int choice ;
        int i ;
        do{
            System.out.println("Enter  your choice : ");
            choice = sc.nextInt() ;
            switch(choice){
                case 1 :
                    new university() ;
                    System.out.println("total student in university : " + university.totalstudent);
                    break ;
                case 2 :
                    System.out.println("Exiting....");
                    break ;
                default :
                    System.out.println("Enter valid choice ! try again");
                    break ;
            }
        }while(choice !=2) ;
    }
}