// Class to calculate sum using Thread
class SumThread extends Thread {
    private int start, end;
    private long sum;

    // Constructor
    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // Run method executed by thread
    @Override
    public void run() {
        sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println("Sum from " + start + " to " + end + " = " + sum);
    }

    // Getter method to return sum
    public long getSum() {
        return sum;
    }
}

// Main class
public class ParallelSum {
    public static void main(String[] args) {
        // Create two threads
        SumThread t1 = new SumThread(1, 1000);
        SumThread t2 = new SumThread(1001, 2000);

        // Start threads (parallel execution)
        t1.start();
        t2.start();

        try {
            // Wait for both threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e);
        }

        // Combine results
        long totalSum = t1.getSum() + t2.getSum();

        // Final output
        System.out.println("Final Total Sum = " + totalSum);
    }
}