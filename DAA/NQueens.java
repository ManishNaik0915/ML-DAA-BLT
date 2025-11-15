import java.util.*;

public class NQueens {
    static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(int[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }
    static void solve(int[][] board, int row, int n) {
        if (row == n) {
            printBoard(board, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 1;
                solve(board, row + 1, n); 
                board[row][col] = 0;      
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        System.out.print("Enter first queen position in first row give col: ");
        
        int c = sc.nextInt();

        board[0][c - 1] = 1;

        System.out.println("\nInitial board:");
        printBoard(board, n);

        System.out.println("Solutions:\n");
        solve(board,1 , n);

        sc.close();
    }
}
