import java.util.Scanner;

public class FractionalKnapsack {

    static double[] weight;
    static double[] value;
    static double[] ratio;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        weight = new double[n];
        value = new double[n];
        ratio = new double[n];

        System.out.println("\nEnter weight and value for each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight Value: ");
            weight[i] = sc.nextDouble();
            value[i] = sc.nextDouble();
            ratio[i] = value[i] / weight[i]; 
        }

        System.out.print("\nEnter knapsack capacity: ");
        double capacity = sc.nextDouble();

        sortByRatio(n);

        double maxValue = fractionalKnapsack(n, capacity);

        System.out.printf("\nMaximum value in knapsack = %.2f\n", maxValue);

        sc.close();
    }

    static void sortByRatio(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {

                    double temp = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = temp;

                    double t1 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t1;

                    double t2 = value[i];
                    value[i] = value[j];
                    value[j] = t2;
                }
            }
        }
    }

    static double fractionalKnapsack(int n, double capacity) {

        double totalValue = 0;

        System.out.println("\nItem selection process:");

        for (int i = 0; i < n; i++) {

            if (capacity == 0)
                break;

            if (weight[i] <= capacity) {
                capacity -= weight[i];
                totalValue += value[i];
                System.out.printf("  Took full item \n", weight[i], value[i]);
            } else {
                double fraction = capacity / weight[i];
                totalValue += value[i] * fraction;
                System.out.printf("  Took fraction of item \n",fraction, weight[i], value[i]);
                capacity = 0;
            }
        }
        return totalValue;
    }
}
