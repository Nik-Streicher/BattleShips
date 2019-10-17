import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int column;
        int row;
        // player 1
        Ships player1 = new Ships();
        Board boardPlayer1 = new Board();
        // player 2
        Ships player2 = new Ships();
        Board boardPlayer2 = new Board();

        Scanner in = new Scanner(System.in);

        System.out.println("Player 1");
        System.out.println("Please enter ships position");
        for (int x = 0; x < 5; x++) {
            System.out.println("1) Horizontal\n2) Vertical");
            player1.place(player1.directory(in.nextInt()));
        }

        System.out.println("Player 2");
        System.out.println("Please enter ships position");
        for (int x = 0; x < 5; x++) {
            System.out.println("1) Horizontal\n2) Vertical");
            player2.place(player2.directory(in.nextInt()));
        }

        while (true) {
            // player 1 turn
            System.out.println("Player 1");
            boardPlayer2.write();
            System.out.println("select fire position (y and x) ");
            column = in.nextInt();
            row = in.nextInt();

            if (player2.hit(column - 1, row - 1)) {
                boardPlayer2.hit(column - 1, row - 1);
            } else boardPlayer2.miss(column - 1, row - 1);
            Thread.sleep(2000);

            //player 2 turn
            System.out.println("Player 2");
            boardPlayer1.write();
            System.out.println("select fire position (y and x) ");
            column = in.nextInt();
            row = in.nextInt();

            if (player1.hit(column - 1, row - 1)) {
                boardPlayer1.hit(column - 1, row - 1);
            } else boardPlayer1.miss(column - 1, row - 1);
            Thread.sleep(2000);
        }
    }
}
