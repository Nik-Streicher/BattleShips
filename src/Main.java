import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // player 1
        Ships player1 = new Ships();
        Board boardPlayer1 = new Board();
        // player 2
        Ships player2 = new Ships();
        Board boardPlayer2 = new Board();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1");
        for(int x = 0;x < 5;x++){
            System.out.println("1) Horizontal\n2) Vertical");
            player1.place(player1.directory(scanner.nextInt()));
        }

        System.out.println("Player 2");
        for(int x = 0;x < 5;x++){
            System.out.println("1) Horizontal\n2) Vertical");
            player2.place(player2.directory(scanner.nextInt()));
        }

    }
}
