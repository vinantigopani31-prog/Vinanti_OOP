package SET_4 ;
import java.util.*;
class Vehicle {
    protected String vehicleNumber;
    protected String Brand;
    protected String fuelType;
    Vehicle(String Vnumber, String Vbrand, String Ftype) {
        vehicleNumber = Vnumber;
        Brand = Vbrand;
        fuelType = Ftype;
    }
    void displayDetails() {
        System.out.println("Vehicle number = : " + vehicleNumber);
        System.out.println("Vehical Brand name : " + Brand);
        System.out.println("Fuel type : " + fuelType);
    }
}
class Car extends Vehicle {
    protected int numberOfSeats;
    protected boolean ACavailable;
    public Car(String Vnumber, String Vbrand, String Ftype, int numberOfSeats, boolean ACavailable) {
        super(Vnumber, Vbrand, Ftype);
        this.numberOfSeats = numberOfSeats;
        this.ACavailable = ACavailable;
    }
    void displayDetails() {
        System.out.println("Vehicle number = : " + vehicleNumber);
        System.out.println("Vehical Brand name : " + Brand);
        System.out.println("Fuel type : " + fuelType);
        System.out.println("Number of seats : " + numberOfSeats);
        System.out.println("AC availbles : " + (ACavailable ? "yes" : "no"));
    }
}
class ElectricCar extends Car{
    protected double batteryCapacity ;
    protected double chargingTime ;
    public ElectricCar(String Vnumber, String Vbrand, String Ftype, int numberOfSeats, boolean ACavailable, double batterycapacity , double chargingtime) {
        super(Vnumber, Vbrand, Ftype, numberOfSeats, ACavailable);
        this.batteryCapacity = batterycapacity ;
        this.chargingTime = chargingtime ;
    }
    void displayDetails(){
        System.out.println("Vehicle number = : " + vehicleNumber);
        System.out.println("Vehical Brand name : " + Brand);
        System.out.println("Fuel type : " + fuelType);
        System.out.println("Number of seats : " + numberOfSeats);
        System.out.println("AC availbles : " + (ACavailable ? "yes" : "no"));
        System.out.println("Battery Capacity : " + batteryCapacity + "KWH");
        System.out.println("Charging Time : " + chargingTime + "Hours");
    } 
}
public class pr-4.1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 if it is vehicle but not car.");
        System.out.println("Press 2 if vehicle is Car");
        System.out.println("Press 3 if vehicle is Electric Car.");
        System.out.println("Press 4 for show Example of up and down Casting.");
        System.out.println("Press 5 for Exit the program.");
        
        int choice ;
        do{
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            switch(choice){
                case 1 :
                    System.out.println("Enter a Vehicle number :");
                    String v1 = sc.next();
                    System.out.println("Enter a brand of vehicle : ");
                    String b1 = sc.next();
                    System.out.println("Enter a tyupe of fule vehicle will use : ");
                    String f1 = sc.next();
                    Vehicle V1 = new Vehicle(v1,b1,f1);
                    System.out.println("Vehicle Details : ");
                    V1.displayDetails();
                    break ;
                case 2 :
                    System.out.println("Enter a Vehicle number :");
                    String v2 = sc.next();
                    System.out.println("Enter a brand of vehicle : ");
                    String b2 = sc.next();
                    System.out.println("Enter a tyupe of fule vehicle will use : ");
                    String f2 = sc.next();
                    System.out.println("Enter number of Seats : ");
                    int s2 = sc.nextInt();
                    System.out.println("Enter AC is Available or not : ");
                    boolean a2 = sc.nextBoolean();
                    Car c1 = new Car(v2,b2,f2,s2,a2);
                    System.out.println("Car Details : ");
                    c1.displayDetails();
                    break ;
                case 3 :
                    System.out.println("Enter a Vehicle number :");
                    String v3 = sc.next();
                    System.out.println("Enter a brand of vehicle : ");
                    String b3 = sc.next();
                    System.out.println("Enter a tyupe of fule vehicle will use : ");
                    String f3 = sc.next();
                    System.out.println("Enter number of Seats : ");
                    int s3 = sc.nextInt();
                    System.out.println("Enter AC is Available or not : ");
                    boolean a3 = sc.nextBoolean();
                    System.out.println("Enter Battery Capacity of car : ");
                    double bc = sc.nextDouble();
                    System.out.println("Enter a charging time : ");
                    double ct = sc.nextDouble();
                    ElectricCar E1 = new ElectricCar(v3,b3,f3,s3,a3,bc,ct);
                    System.out.println("Electric car details : ");
                    E1.displayDetails();
                    break ;
                case 4 :
                    System.out.println("====== || Upcasting Example : || =====");
                    Vehicle vobj = new Car("GJ05SU1234","BMW","PETROL",5,true);
                    vobj.displayDetails();
                    System.out.println("====== || Downcasting Example : || =====");
                    if(vobj instanceof Car){
                        Car cobj = (Car)vobj ;
                        System.out.println("Number of Seats : " + cobj.numberOfSeats);
                        System.out.println("AC available : " + (cobj.ACavailable ? "Yes" : "NO"));
                    }
                    break ;
                case 5 :
                    System.out.println("Exiting......");
                    break;
                default :
                    System.out.println("Enter valid choice ! try again");
                    break ;
            }
        }while(choice != 5);    
        sc.close();
    }
}