import java.util.ArrayList;

class Ships {

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

    //Get methods

    ArrayList<Integer> getAircraftCarrier() {
        return aircraftCarrier;
    }

    ArrayList<Integer> getBattleship() {
        return battleship;
    }

    ArrayList<Integer> getCruiser() {
        return cruiser;
    }

    ArrayList<Integer> getDestroyer() {
        return destroyer;
    }

    ArrayList<Integer> getLocationOAircraftCarrier() {
        return locationOAircraftCarrier;
    }

    ArrayList<Integer> getLocationOfBattleship() {
        return locationOfBattleship;
    }

    ArrayList<Integer> getLocationOfCruiser() {
        return locationOfCruiser;
    }

    ArrayList<Integer> getLocationOfDestroyer() {
        return locationOfDestroyer;
    }

    //Checking hits
    private boolean ignoredHit(int column, int row, ArrayList<Integer> one, ArrayList<Integer> two) {
        for (int w : one) {
            if (w == column) {
                for (int r : two) {
                    if (row == r)
                        return true;
                }
            }
        }
        return false;
    }
    //Checkin hits
    boolean hit(int y, int x) {
        if (ignoredHit(y, x, aircraftCarrier, locationOAircraftCarrier)) {
            return true;

        } else if (ignoredHit(y, x, battleship, locationOfBattleship)) {
            return true;

        } else if (ignoredHit(y, x, cruiser, locationOfCruiser)) {
            return true;

        } else return ignoredHit(y, x, destroyer, locationOfDestroyer);
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
}
