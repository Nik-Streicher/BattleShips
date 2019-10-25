class Run {

    public static void main(String[] args) throws InterruptedException {
        Run run = new Run();
        run.runFill();
        run.runFire(run.boardPlayer2, run.boardPlayer1);
    }
    // player 1
    private Board boardPlayer1 = new Board();

    // player 2
    private Board boardPlayer2 = new Board();

    private void runFill() {
        //player 1 fill phase
        System.out.println("Player 1");
        boardPlayer1.fill();
        //player 2 fill phase
        System.out.println("Player 2");
        boardPlayer2.fill();
    }

    private void runFire(Board boardPlayer2, Board boardPlayer1) throws InterruptedException {
        while (true) {
            // player 1 turn
            System.out.println("Player 1");
            boardPlayer2.firePhase();

            if (Win.complete(boardPlayer2.getBoard())) {
                System.out.println("Player 1 wins");
                return;
            }
            //player 2 turn
            System.out.println("Player 2");
            boardPlayer1.firePhase();

            if (Win.complete(boardPlayer1.getBoard())) {
                System.out.println("Player 2 wins");
                return;
            }
        }
    }
}
