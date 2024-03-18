import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private int size;
    private char currentPlayer;

    public TicTacToe(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
        currentPlayer = 'X';
    }
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (!isGameFinished()) {
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn. Enter row and column (1-" + size + "):");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if (isWin(row, col)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    return;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    return;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-';
    }

    private boolean isWin(int row, int col) {
        return checkRow(row) || checkColumn(col) || checkDiagonals(row, col);
    }

    private boolean checkRow(int row) {
        for (int j = 0; j < size; j++) {
            if (board[row][j] != currentPlayer)
                return false;
        }
        return true;
    }

    private boolean checkColumn(int col) {
        for (int i = 0; i < size; i++) {
            if (board[i][col] != currentPlayer)
                return false;
        }
        return true;
    }

    private boolean checkDiagonals(int row, int col) {
        boolean diagonal1 = true, diagonal2 = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != currentPlayer)
                diagonal1 = false;
            if (board[i][size - 1 - i] != currentPlayer)
                diagonal2 = false;
        }
        return diagonal1 || diagonal2;
    }

    private boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    private boolean isGameFinished() {
        return isWin(size - 1, size - 1) || isDraw();
    }

}
