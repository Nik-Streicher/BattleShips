import java.util.Arrays;
import java.util.Scanner;

class Board {

    // player 1
    private Ships player1 = new Ships();
    private Board boardPlayer1 = new Board();

    // player 2
    private Ships player2 = new Ships();
    private Board boardPlayer2 = new Board();

    //Scanner
    private Scanner in = new Scanner(System.in);

    // Ending class
    private Win win = new Win();

    void runFill(){
        //player 1 fill phase
        System.out.println("Player 1");
        fill(player1, in);
        //player 2 fill phase
        System.out.println("Player 2");
        fill(player2, in);
    }

    void runFire() throws InterruptedException {
        while (true) {
            // player 1 turn
            System.out.println("Player 1");
            firePhase(player2, boardPlayer2, in);

            if(win.complete(boardPlayer2.getBoard())){
                System.out.println("Player 1 wins");
                return;
            }
            //player 2 turn
            System.out.println("Player 2");
            firePhase(player1, boardPlayer1, in);

            if(win.complete(boardPlayer1.getBoard())){
                System.out.println("Player 2 wins");
                return;
            }
        }
    }

    private void firePhase(Ships player, Board boardPlayer, Scanner in) throws InterruptedException {
        int column;
        int row;
        boardPlayer.write();
        System.out.println("select fire position (y and x) ");
        column = in.nextInt();
        row = in.nextInt();

        if (player.hit(column - 1, row - 1)) {
            boardPlayer.hit(column - 1, row - 1);
        } else boardPlayer.miss(column - 1, row - 1);
        Thread.sleep(2000);
    }

    private void fill(Ships player, Scanner in) {
        System.out.println("Please enter ships position");
        for (int x = 0; x < 5; x++) {
            System.out.println("1) Horizontal\n2) Vertical");
            player.place(player.directory(in.nextInt()));
        }
    }

    // getter
    private char[][] getBoard() {
        return board;
    }

    //create a board.
    private char[][] board = new char[10][10];

    //Fill a board.
    Board() {
        for (char[] array : board) Arrays.fill(array, 'o');
    }

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

