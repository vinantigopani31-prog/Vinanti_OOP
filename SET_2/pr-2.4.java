import java.util.* ;
class loancalculator{
    void calculateEMI(int principal , int time , float rate){
        double r = rate / (12 * 100) ;
        int t = time * 12 ;
        double emi = (principal * r * Math.pow(1+r,t)) / (Math.pow(1+r,t)-1);
        System.out.println(" Home loan EMI : " + emi);
    }
    void calculateEMI(double principal , int time , double rate) {
        double r = rate / (12 * 100) ;
        int t = time * 12 ;
        double emi = (principal * r * Math.pow(1+r,t)) / (Math.pow(1+r,t)-1);
        System.out.println("Vehicle loan EMI : " + emi);
    }
    void calculateEMI(int principal , int time){
        double rate = 10 ;
        double r = rate / (12 * 100) ;
        int t = time * 12 ;
        double emi = (principal * r * Math.pow(1+r,t)) / (Math.pow(1+r,t)-1);
        System.out.println("Personal loan EMI : " + emi);
    }
}
public class pr-2.4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loancalculator lc = new loancalculator() ;
        System.out.println("======EMI calculator======");
        System.out.println("press 1 for Home loan.");
        System.out.println("Press 2 for Vehicle loan.");
        System.out.println("press 3 for Personal loan.");
        System.out.println("==========================");
        int choice ;
        do{
            System.out.println("Enter type of loan : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    System.out.println("Enter Principal amount : ");
                    int p1 = sc.nextInt();
                    System.out.println("Enter Time(years) : ");
                    int t1 = sc.nextInt();
                    System.out.println("Enter Rate of interest : ");
                    float r1 = sc.nextFloat() ;
                    lc.calculateEMI(p1, t1, r1);
                    break ;
                case 2 :
                    System.out.println("Enter Principal amount : ");
                    double p2 = sc.nextDouble();
                    System.out.println("Enter Time(years) : ");
                    int t2 = sc.nextInt();
                    System.out.println("Enter Rate of interest : ");
                    double r2 = sc.nextDouble() ;
                    lc.calculateEMI(p2, t2, r2);
                    break ;
                case 3 :
                    System.out.println("Enter Principal amount : ");
                    int p3 = sc.nextInt();
                    System.out.println("Enter Time(years) : ");
                    int t3 = sc.nextInt();
                    lc.calculateEMI(p3, t3);
                    break ;
                case 4 :
                    System.out.println("Exiting....");
                    break ;
                default:
                    System.out.println("Please Enter valid choice! Try agian");
                    break;
            }           
        }while(choice != 4);
        sc.close();
    }
}