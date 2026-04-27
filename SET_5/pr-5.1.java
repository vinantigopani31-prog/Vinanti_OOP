import java.util.*;
// Interface
interface Order {
    void placeOrder(String item, int qty);
    void cancelOrder(int orderId);
    void generateBill();
}
// Abstract class (partial implementation)
abstract class PartialOrder implements Order {
    String itemName;
    int quantity;
    int orderId;
    double price;

    public void placeOrder(String item, int qty) {
        this.itemName = item;
        this.quantity = qty;
        System.out.println("Order placed successfully for " + quantity + " " + itemName);
    }
}
// Concrete class
class FinalOrder extends PartialOrder {

    FinalOrder(int orderId, double price) {
        this.orderId = orderId;
        this.price = price;
    }

    // Cancel order
    public void cancelOrder(int orderId) {
        if (this.orderId == orderId && itemName != null) {
            System.out.println("Order ID " + orderId + " has been cancelled.");
            itemName = null;
            quantity = 0;
        } else {
            System.out.println("Invalid Order ID or order already cancelled.");
        }
    }

    // Generate bill
    public void generateBill() {
        if (itemName == null || quantity == 0) {
            System.out.println("No active order to generate bill.");
            return;
        }

        double total = quantity * price;

        System.out.println("\n====== || BILL || ======");
        System.out.println("Order ID : " + orderId);
        System.out.println("Item Name : " + itemName);
        System.out.println("Quantity : " + quantity);
        System.out.println("Price per item : Rs. " + price);
        System.out.println("Total Amount : Rs. " + total);
        System.out.println("========================");
    }
}

// Main class
public class pr-5.1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Order ID:");
        int orderId = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.println("Enter Item Name:");
        String itemName = sc.nextLine();

        System.out.println("Enter Quantity:");
        int qty = sc.nextInt();

        System.out.println("Enter Price per item:");
        double price = sc.nextDouble();

        FinalOrder order = new FinalOrder(orderId, price);
        order.placeOrder(itemName, qty);

        int choice;
        do {
            System.out.println("\n====== || MENU || ======");
            System.out.println("1. Generate Bill");
            System.out.println("2. Cancel Order");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    order.generateBill();
                    break;

                case 2:
                    System.out.println("Enter Order ID to cancel:");
                    int cancelId = sc.nextInt();
                    order.cancelOrder(cancelId);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}