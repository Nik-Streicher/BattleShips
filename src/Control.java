import java.util.ArrayList;
import java.util.Scanner;

class Control {
    private Ships ships = new Ships();
    private Board board = new Board();
    private Scanner in = new Scanner(System.in);

    //Set
    private void set(int position, int start, String value, ArrayList<Integer> ship, ArrayList<Integer> shipLocation) {
        if (value.equals("horizon")) {
            for (int x = 0; x < 5; x++) {
                ship.add(start);
                start++;
            }
            shipLocation.add(position);

        } else if (value.equals("vertical")) {
            for (int x = 0; x < 5; x++) {
                ship.add(start);
                start++;
            }
            shipLocation.add(position);

        } else System.out.println("wrong syntax");
    }

    //"place" ship on the board
    private void place(String value) {
        System.out.println("please enter directory");
        int position = in.nextInt();

        System.out.println("Please enter start position");
        int start = in.nextInt();

        int type;

        switch (start) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("1) AirCraftCarrier (5)\n2) BattleShip (4)\n3) Cruiser (3)\n4) Destroyer (2)");
                type = in.nextInt();
                switch (type) {
                    case 1:
                        set(position, start, value, ships.getAircraftCarrier(), ships.getLocationOAircraftCarrier());
                        break;
                    case 2:
                        set(position, start, value, ships.getBattleship(), ships.getLocationOfBattleship());
                        break;
                    case 3:
                        set(position, start, value, ships.getCruiser(), ships.getLocationOfCruiser());
                        break;
                    case 4:
                        set(position, start, value, ships.getDestroyer(), ships.getLocationOfDestroyer());
                        break;
                    default:
                        System.out.println("Wrong syntax");
                }
                break;
            case 7:
                System.out.println("2) BattleShip (4)\n3) Cruiser (3)\n4) Destroyer (2)");
                type = in.nextInt();
                switch (type) {
                    case 2:
                        set(position, start, value, ships.getBattleship(), ships.getLocationOfBattleship());
                        break;
                    case 3:
                        set(position, start, value, ships.getCruiser(), ships.getLocationOfCruiser());
                        break;
                    case 4:
                        set(position, start, value, ships.getDestroyer(), ships.getLocationOfDestroyer());
                        break;
                }
                break;
            case 8:
                System.out.println("3) Cruiser (3)\n4) Destroyer (2)");
                type = in.nextInt();
                switch (type) {
                    case 3:
                        set(position, start, value, ships.getCruiser(), ships.getLocationOfCruiser());
                        break;
                    case 4:
                        set(position, start, value, ships.getDestroyer(), ships.getLocationOfDestroyer());
                        break;
                }
                break;
            case 9:
                System.out.println("Destroyer set");
                //set destroyer
                set(position, start, value, ships.getDestroyer(), ships.getLocationOfDestroyer());
                break;
            default:
                System.out.println("Wrong syntax");
        }
    }

    void firePhase(){
        int column;
        int row;
        write();
        System.out.println("select fire position (y and x) ");
        column = in.nextInt();
        row = in.nextInt();

        try{
            if (ships.hit(column - 1, row - 1)) {
                hit(column - 1, row - 1);
            } else miss(column - 1, row - 1);
            Thread.sleep(2000);
        }catch (InterruptedException ignored){
        }
    }

    void fill() {
        System.out.println("Please enter ships position");
        for (int x = 0; x < 5; x++) {
            System.out.println("1) Horizontal\n2) Vertical");
            place(ships.directory(in.nextInt()));
        }
    }

    //Write the Board.
    private void write() {
        for (char[] array : board.getBoard()) {
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
        for (int x = 0; x < board.getBoard().length; x++) {
            for (int y = 0; y < board.getBoard()[x].length; y++)
                if (x == column && y == row) {
                    board.getBoard()[x][y] = sign;
                    System.out.print(board.getBoard()[x][y] + " ");
                } else
                    System.out.print(board.getBoard()[x][y] + " ");

            System.out.println();
        }
    }

    //copy bord from ships
    char[][] getBoard(){
        return board.getBoard();
    }
}
