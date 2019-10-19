import java.util.Arrays;
import java.util.Scanner;

class Board {


    //fill the board
    Board() {
        for (char[] array : board) Arrays.fill(array, 'o');
    }

    //Scanner
    private Scanner in = new Scanner(System.in);

    private Ships player = new Ships();

    void firePhase() throws InterruptedException {
        int column;
        int row;
        write();
        System.out.println("select fire position (y and x) ");
        column = in.nextInt();
        row = in.nextInt();

        if (player.hit(column - 1, row - 1)) {
            hit(column - 1, row - 1);
        } else miss(column - 1, row - 1);
        Thread.sleep(2000);
    }

    void fill() {
        System.out.println("Please enter ships position");
        for (int x = 0; x < 5; x++) {
            System.out.println("1) Horizontal\n2) Vertical");
            player.place(player.directory(in.nextInt()));
        }
    }

    // getter
    char[][] getBoard() {
        return board;
    }

    //create a board.
    private char[][] board = new char[10][10];

    //Write the Board.
    private void write() {
        for (char[] array : board) {
            for (char interArray : array) System.out.print(interArray + " ");
            System.out.println();
        }
    }

    //Write hit.
    private void hit(int column, int row) {
        part('@', column, row);
    }

    //Write miss.
    private void miss(int column, int row) {
        part('X', column, row);
    }

    //write method
    private void part(char sign, int column, int row) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++)
                if (x == column && y == row) {
                    board[x][y] = sign;
                    System.out.print(board[x][y] + " ");
                } else
                    System.out.print(board[x][y] + " ");

            System.out.println();
        }

    }
}

