import java.util.Scanner;

public class NonRecursiveFibonacci {

    public static int fib(int n) {
        int n1 = 0, n2 = 1;
        int steps = 0; 

        System.out.print(n1 + " " + n2 + " ");

        for (int i = 2; i < n; i++) {
            steps++;

            int n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;
        }
        System.out.println();

        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        System.out.print("Fibonacci Series: ");
        int stepCount = fib(n);

        System.out.println("Step Count: " + stepCount);
        
        sc.close();
    }
}
