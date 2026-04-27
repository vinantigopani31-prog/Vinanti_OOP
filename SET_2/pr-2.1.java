package pr2 ;
import java.util.* ;
class time {
    int hours ;
    int minute ;
    void settime(int h , int m){
        hours = h ;
        minute = m ;
    }
    void display(){
        System.out.println(hours + "hours" + minute + " minute");
    }
    void addtime(time t1 , time t2) {
        int total_minute = t1.minute + t2.minute ;
        int total_hours = t1.hours + t2.hours ;
      
        if(total_minute >= 60)
        {
            total_hours += total_minute / 60 ;
            total_minute = total_minute % 60 ;
        }

        hours = total_hours ;
        minute = total_minute ;
    }
}
public class pr-2.1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        time t1 = new time() ;
        time t2 = new time() ;
        time t3 = new time() ;

        System.out.println("Enter hours for time T1 : ");
        int h1 = sc.nextInt();
        System.out.println("Enter minute for time T1 : ");
        int m1 = sc.nextInt();
        t1.settime(h1, m1);
        System.out.println("Enter hours for time T2 : ");
        int h2 = sc.nextInt();
        System.out.println("Enter minute for time T2 : ");
        int m2 = sc.nextInt();
        t2.settime(h2, m2);
        
        t3.addtime(t1,t2);

        System.out.println("Time t1 : ");
        t1.display();
        System.out.println("Time t2 : ");
        t2.display();
        System.out.println("Time t3 : ");
        t3.display();
        
        sc.close();
    }
}
