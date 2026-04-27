import java.util.*;

// Generic Class
class Box<T> {
    private ArrayList<T> items = new ArrayList<>();

    // Method to add item
    public void addItem(T item) {
        items.add(item);
    }

    // Method to display items
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Box<String> for names
        Box<String> nameBox = new Box<>();
        nameBox.addItem("scadric");
        nameBox.addItem("luna");
        nameBox.addItem("Fenni");

        System.out.println("Names in Box:");
        nameBox.displayItems();

        // Box<Integer> for roll numbers
        Box<Integer> rollBox = new Box<>();
        rollBox.addItem(101);
        rollBox.addItem(102);
        rollBox.addItem(103);

        System.out.println("\nRoll Numbers in Box:");
        rollBox.displayItems();
    }
}