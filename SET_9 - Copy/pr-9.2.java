import java.util.*;

class SortUtil {

    // Generic method with bounded type
    public static <T extends Comparable<T>> void sortList(List<T> list) {
        Collections.sort(list);
    }
}

public class Main {
    public static void main(String[] args) {

        // --- ArrayList<Integer> ---
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(78);
        numbers.add(23);

        System.out.println("Before Sorting (Numbers): " + numbers);
        SortUtil.sortList(numbers);
        System.out.println("After Sorting (Numbers): " + numbers);

        // --- ArrayList<String> ---
        ArrayList<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Aman");
        names.add("Neha");
        names.add("Ravi");

        System.out.println("\nBefore Sorting (Names): " + names);
        SortUtil.sortList(names);
        System.out.println("After Sorting (Names): " + names);
    }
}