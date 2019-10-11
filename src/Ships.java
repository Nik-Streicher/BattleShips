import java.util.ArrayList;
import java.util.Scanner;

class Ships {
    private Scanner in = new Scanner(System.in);

    //Ships
    private ArrayList<Integer> aircraftCarrier = new ArrayList<>();
    private ArrayList<Integer> battleship = new ArrayList<>();
    private ArrayList<Integer> cruiser = new ArrayList<>();
    private ArrayList<Integer> destroyer = new ArrayList<>();
    //Ships Locations
    private ArrayList<Integer> locationOAircraftCarrier = new ArrayList<>();
    private ArrayList<Integer> locationOfBattleship = new ArrayList<>();
    private ArrayList<Integer> locationOfCruiser = new ArrayList<>();
    private ArrayList<Integer> locationOfDestroyer = new ArrayList<>();


    Ships() {

    }

    //Checking hits
    private boolean ignoredHit(int y, int x, ArrayList<Integer> one, ArrayList<Integer> two) {
        for (int w : one) {
            if (w == y) {
                for (int r : two) {
                    if (x == r)
                        return true;
                }
            }
        }
        return false;
    }

    void hit(int y, int x) {
        if (ignoredHit(y, x, aircraftCarrier, locationOAircraftCarrier)) {
            System.out.println("Hit");

        } else if (ignoredHit(y, x, battleship, locationOfBattleship)) {
            System.out.println("Hit");

        } else if (ignoredHit(y, x, cruiser, locationOfCruiser)) {
            System.out.println("Hit");

        } else if (ignoredHit(y, x, destroyer, locationOfDestroyer))
            System.out.println("Hit");

        else System.out.println("Miss");
    }


    //Set
    private void set(int position, int start, String value,ArrayList<Integer> ship,ArrayList<Integer> shipLocation) {
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

    //checking horizontal or vertical
    String directory(int number) {
        if (number == 1) {
            return "horizon";
        } else if (number == 2) {
            return "vertical";
        } else System.out.println("Wrong syntax");
        return "null";
    }

    //"place" ship on the board
    void place(String value) {
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
                        set(position,start,value,aircraftCarrier,locationOAircraftCarrier);
                        break;
                    case 2:
                        set(position,start,value,battleship,locationOfBattleship);
                        break;
                    case 3:
                        set(position,start,value,cruiser,locationOfCruiser);
                        break;
                    case 4:
                        set(position,start,value,destroyer,locationOfDestroyer);
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
                        set(position,start,value,battleship,locationOfBattleship);
                        break;
                    case 3:
                        set(position,start,value,cruiser,locationOfCruiser);
                        break;
                    case 4:
                        set(position,start,value,destroyer,locationOfDestroyer);
                        break;
                }
                break;
            case 8:
                System.out.println("3) Cruiser (3)\n4) Destroyer (2)");
                type = in.nextInt();
                switch (type) {
                    case 3:
                        set(position,start,value,cruiser,locationOfCruiser);
                        break;
                    case 4:
                        set(position,start,value,destroyer,locationOfDestroyer);
                        break;
                }
                break;
            case 9:
                System.out.println("Destroyer set");
                //set destroyer
                set(position,start,value,destroyer,locationOfDestroyer);
                break;
            default:
                System.out.println("Wrong syntax");
        }
    }
}
