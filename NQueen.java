public class NQueen {

    static int N = 8;
    static char[][] board = new char[N][N];

    static boolean isSafe(char board[][], int row, int col) {

        int i, j;

        // check left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // upper left diagonal
        for (j = col, i = row; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // lower left diagonal
        for (j = col, i = row; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static boolean NQuuenUtil(char board[][], int col) {

        if (col >= N) {
            return true;
        }

        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';

                if (NQuuenUtil(board, col + 1)) {
                    return true;
                }

                board[i][col] = '*'; // backtrack
            }
        }

        return false;
    }

    static void printSoul() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    static void fillBoard() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '*';
                System.out.print(board[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {

        fillBoard();
        System.out.println("");
        printSoul();
        System.out.println(" ");

        if (!NQuuenUtil(board, 0)) {
            System.out.println("no solution exist!!!");
        } else {
            printSoul();
        }
    }
}
