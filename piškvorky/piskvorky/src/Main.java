import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Enter the size of the board (3, 5, or 6): ");
        int size = scanner.nextInt();
        if (size != 3 && size != 5 && size != 6) {
            System.out.println("Invalid size! Please choose either 3, 5, or 6.");
            return;
        }
        TicTacToe game = new TicTacToe(size);
        game.startGame();
    }
}