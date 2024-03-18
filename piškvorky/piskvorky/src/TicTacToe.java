public class TicTacToe {
    private char[][] board;
    private int size;
    private char currentPlayer;

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }
    public TicTacToe(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
        currentPlayer = 'X';
    }
}
