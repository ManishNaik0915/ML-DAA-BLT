import java.util.Scanner;

public class RecursiveFibonacci {

    static int steps = 0;

    public static int fib(int n) {
        steps++; // count each call

        if (n <= 1)
            return n;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();

        System.out.print("Fibonacci Series: ");

        steps = 0; // reset before all calculations

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }

        System.out.println("\nTotal Steps: " + steps);

        sc.close();
    }
}
