/**
 * Exercicio 10:
 * Um teatro possui 3000 lugares divididos em 30 fileiras, cada uma com 100 cadeiras.
 * Elaborar um programa em linguagem Java, capaz de gerenciar a venda dos ingressos
 * para este teatro. Cada lugar poderá estar Livre (0), Reservado (1) ou Vendido (2).
 */

import java.util.Scanner;

public class ex10 {
    static final int THEATER_ROWS = 30;
    static final int THEATER_COLS = 100;
    
    static final int AVAILABLE_SEATS = 0;
    static final int RESERVED_SEATS = 1;
    static final int SOLD_SEATS = 2;

    static int[][] seats = new int[THEATER_ROWS][THEATER_COLS];

    public static void main(String[] args) {
        initSeats();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sellTicket(scanner);
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    showStatus();
                    break;
                default:
                    // do nothing
            }
        } while (choice != 5);

        scanner.close();
    }

    static void initSeats() {
        for (int row = 0; row < THEATER_ROWS; row++) {
            for (int col = 0; col < THEATER_COLS; col++) {
                seats[row][col] = AVAILABLE_SEATS;
            }
        }
    }

    static void showMenu() {
        System.out.println("1-Sell 2-Reserve 3-Cancel reservation 4-Show status 5-Exit");
    }

    static void sellTicket(Scanner scanner) {
        System.out.println("Row (0-" + (THEATER_ROWS - 1) + ") and Seat (0-" + (THEATER_COLS - 1) + "):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if (validSeat(row, col) && seats[row][col] == AVAILABLE_SEATS) {
            seats[row][col] = SOLD_SEATS;
            System.out.println("Sold.");
        } else {
            System.out.println("Seat unavailable.");
        }
    }

    static void reserveSeat(Scanner scanner) {
        System.out.println("Row (0-" + (THEATER_ROWS - 1) + ") and Seat (0-" + (THEATER_COLS - 1) + "):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if (validSeat(row, col) && seats[row][col] == AVAILABLE_SEATS) {
            seats[row][col] = RESERVED_SEATS;
            System.out.println("Reserved.");
        } else {
            System.out.println("Seat unavailable.");
        }
    }

    static void cancelReservation(Scanner scanner) {
        System.out.println("Row (0-" + (THEATER_ROWS - 1) + ") and Seat (0-" + (THEATER_COLS - 1) + "):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if (validSeat(row, col) && seats[row][col] == RESERVED_SEATS) {
            seats[row][col] = AVAILABLE_SEATS;
            System.out.println("Reservation cancelled.");
        } else {
            System.out.println("Not a reservation or invalid seat.");
        }
    }

    static void showStatus() {
        int availableCount = 0;
        int reservedCount = 0;
        int soldCount = 0;
        for (int row = 0; row < THEATER_ROWS; row++) {
            for (int col = 0; col < THEATER_COLS; col++) {
                if (seats[row][col] == AVAILABLE_SEATS) availableCount++;
                else if (seats[row][col] == RESERVED_SEATS) reservedCount++;
                else soldCount++;
            }
        }
        System.out.println("Available: " + availableCount + " Reserved: " + reservedCount + " Sold: " + soldCount);
    }

    static boolean validSeat(int row, int col) {
        return row >= 0 && row < THEATER_ROWS && col >= 0 && col < THEATER_COLS;
    }
}
