import java.util.Arrays;

class Board {
    //create a board.
    private char[][] board = new char[10][10];

    //Fill a board.
    Board() {
        for (char[] array : board) Arrays.fill(array, 'o');
    }

    //Write the Board.
    void write() {
        for (char[] array : board) {
            for (char interArray : array) System.out.print(interArray + " ");
            System.out.println();
        }
    }

    //Write hit.
    void hit(int column, int row) {
        part('@', column, row);
    }

    //Write miss.
    void miss(int column, int row) {
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

