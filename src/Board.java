import java.util.Arrays;
class Board {

    //fill the board
    Board() {
        for (char[] array : board) Arrays.fill(array, 'o');
    }

    // getter
    char[][] getBoard() {
        return board;
    }

    //create a board.
    private char[][] board = new char[10][10];


}

