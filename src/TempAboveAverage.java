
import java.util.Scanner;

public class TempAboveAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of temperature readings: ");
        int n = scanner.nextInt();
        double[] temperatures = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
            sum += temperatures[i];
        }

        double average = sum / n;
        System.out.println("Average temperature: " + average);
        int countAboveAverage = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                countAboveAverage++;
            }
        }

        System.out.println("Number of days above average temperature: " + countAboveAverage);
    }
}
