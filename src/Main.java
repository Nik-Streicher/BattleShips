import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // player 1
        Ships player1 = new Ships();
        Board boardPlayer1 = new Board();
        // player 2
        Ships player2 = new Ships();
        Board boardPlayer2 = new Board();

        //Scanner
        Scanner in = new Scanner(System.in);

        // Ending class
        Win win = new Win();
        //player 1 fill phase
        System.out.println("Player 1");
        fill(player1, in);
        //player 2 fill phase
        System.out.println("Player 2");
        fill(player2, in);

        //Need phase ending
        //add Win phase later
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

    private static void firePhase(Ships player, Board boardPlayer, Scanner in) throws InterruptedException {
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

    private static void fill(Ships player, Scanner in) {
        System.out.println("Please enter ships position");
        for (int x = 0; x < 5; x++) {
            System.out.println("1) Horizontal\n2) Vertical");
            player.place(player.directory(in.nextInt()));
        }
    }
}
