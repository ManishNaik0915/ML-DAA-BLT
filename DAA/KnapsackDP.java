import java.util.Scanner;

public class KnapsackDP {

    public static int knapsackDP(int[] weights, int[] profits, int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] profits = new int[n];

        System.out.println("Enter weight and profit for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print(" Weight for Item " + (i + 1) + ": ");
            weights[i] = sc.nextInt();
            System.out.print(" Profit for Item " + (i + 1) + ": ");
            profits[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int capacity = sc.nextInt();

        int maxProfit = knapsackDP(weights, profits, n, capacity);

        System.out.println("\nMaximum Profit = " + maxProfit);
        sc.close();
    }
}
