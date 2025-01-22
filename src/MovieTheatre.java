import java.util.Scanner;

public class MovieTheatre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 5;
        int cols = 10;
        int[][] seatingChart = new int[rows][cols];

        boolean running = true;

        System.out.println("Welcome to Not the Cineplex");
        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. View seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Please pick an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewSeatingChart(seatingChart);
                    break;
                case 2:
                    reserveSeat(seatingChart, scanner);
                    break;
                case 3:
                    cancelSeat(seatingChart, scanner);
                    break;
                case 4:
                    System.out.println("Thank you for choosing our Movie Theater!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void viewSeatingChart(int[][] seatingChart) {
        System.out.println("\nSeating Chart (0 = Available, 1 = Reserved):");
        int i = 0;
        while (i < seatingChart.length) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
            i++;
        }
    }

    private static void reserveSeat(int[][] seatingChart, Scanner scanner) {
        System.out.print("Enter row (1 to " + seatingChart.length + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat (1 to " + seatingChart[0].length + "): ");
        int seat = scanner.nextInt() - 1;

        if (isValidSeat(seatingChart, row, seat)) {
            if (seatingChart[row][seat] == 0) {
                seatingChart[row][seat] = 1;
                System.out.println("Your seat has been reserved!");
            } else {
                System.out.println("This seat has already been reserved. We'll suggest a seat for you.");
                suggestSeat(seatingChart);
            }
        } else {
            System.out.println("Invalid seat number. Please pick another seat.");
        }
    }

    private static void cancelSeat(int[][] seatingChart, Scanner scanner) {
        System.out.print("Enter row (1 to " + seatingChart.length + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat (1 to " + seatingChart[0].length + "): ");
        int seat = scanner.nextInt() - 1;

        if (isValidSeat(seatingChart, row, seat)) {
            if (seatingChart[row][seat] == 1) {
                seatingChart[row][seat] = 0;
                System.out.println("Reservation canceled successfully!");
            } else {
                System.out.println("Seat is not reserved.");
            }
        } else {
            System.out.println("Invalid seat number. Please pick another seat.");
        }
    }

    private static boolean isValidSeat(int[][] seatingChart, int row, int seat) {
        return row >= 0 && row < seatingChart.length && seat >= 0 && seat < seatingChart[0].length;
    }

    private static void suggestSeat(int[][] seatingChart) {
        for (int i = 0; i < seatingChart.length; i++) {
            for (int j = 0; j < seatingChart[i].length; j++) {
                if (seatingChart[i][j] == 0) {
                    System.out.println("Suggested seat: Row " + (i + 1) + ", Seat " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }
}

