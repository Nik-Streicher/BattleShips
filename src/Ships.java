import java.util.ArrayList;
import java.util.Scanner;

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

    //Checking hits
    private boolean ignoredHit(int y, int x,ArrayList<Integer> one,ArrayList<Integer> two){
        for(int w: one){
            if(w == y){
                for(int r: two){
                    if(x == r)
                        return true;
                }
            }
        }
        return false;
    }

    void hit(int y,int x){
       if(ignoredHit(y,x,aircraftCarrier,locationOAircraftCarrier)){
           System.out.println("Hit");

       }else if(ignoredHit(y,x,battleship,locationOfBattleship)) {
           System.out.println("Hit");

       }else  if(ignoredHit(y,x,cruiser,locationOfCruiser)) {
           System.out.println("Hit");

       }else if(ignoredHit(y,x,destroyer,locationOfDestroyer))
           System.out.println("Hit");

       else System.out.println("Miss");
    }


    //Set
    private void setAircraftCarrier(int position ,int startAircraftCarrier,String value) {
        if(value.equals("horizon")){
            for(int x = 0; x < 5; x++){
                aircraftCarrier.add(startAircraftCarrier);
                startAircraftCarrier++;
            }
            locationOAircraftCarrier.add(position);

        }else if(value.equals("vertical")){
            for(int x = 0; x < 5; x++){
                locationOAircraftCarrier.add(startAircraftCarrier);
                startAircraftCarrier++;
            }
            aircraftCarrier.add(position);

        }else System.out.println("wrong syntax");
    }

    private void setBattleship(int position ,int startBattleship,String value) {
        if(value.equals("horizon")){
            for(int x = 0; x < 5; x++){
                battleship.add(startBattleship);
                startBattleship++;
            }
            locationOfBattleship.add(position);

        }else if(value.equals("vertical")){
            for(int x = 0; x < 5; x++){
                battleship.add(startBattleship);
                startBattleship++;
            }
            battleship.add(position);

        }else System.out.println("wrong syntax");
    }

    private void setCruiser(int position ,int startCruiser,String value) {
        if(value.equals("horizon")){
            for(int x = 0; x < 5; x++){
                cruiser.add(startCruiser);
                startCruiser++;
            }
            locationOfCruiser.add(position);

        }else if(value.equals("vertical")){
            for(int x = 0; x < 5; x++){
                locationOfCruiser.add(startCruiser);
                startCruiser++;
            }
            cruiser.add(position);

        }else System.out.println("wrong syntax");
    }

    private void setDestroyer(int position ,int startDestroyer,String value) {
        if(value.equals("horizon")){
            for(int x = 0; x < 5; x++){
                destroyer.add(startDestroyer);
                startDestroyer++;
            }
            locationOfDestroyer.add(position);

        }else if(value.equals("vertical")){
            for(int x = 0; x < 5; x++){
                locationOfDestroyer.add(startDestroyer);
                startDestroyer++;
            }
            destroyer.add(position);

        }else System.out.println("wrong syntax");
    }

    //checking horizontal or vertical
    String directory(int number){
        if(number == 1){
            return "horizon";
        }else if(number == 2){
            return "vertical";
        }else System.out.println("Wrong syntax");
        return "null";
    }


    //chose ship
    private void typeOfShip(int type,int startPosition,String value,int position) {
        switch (type) {
            case 1:
                setAircraftCarrier(position,startPosition,value);
                break;
            case 2:
                setBattleship(position,startPosition,value);
                break;
            case 3:
                setCruiser(position,startPosition,value);
                break;
            case 4:
                setDestroyer(position,startPosition,value);
                break;
        }
    }

    //"place" ship on the board
    void place(String value){
            try(Scanner in = new Scanner(System.in)){

                System.out.println("please enter directory");
                int position = in.nextInt();

                System.out.println("Please enter start position");
                int start = in.nextInt();

                int type;

                switch (start) {
                    case 1: case 2: case 3: case 4: case 5:case 6:
                        System.out.println("1) AirCraftCarrier (5)\n2) BattleShip (4)\n3) Cruiser (3)\n4) Destroyer (2)");
                        type = in.nextInt();
                        switch (type){
                            case 1:
                                typeOfShip(1,start,value,position);
                                System.out.println("im here");
                                break;
                            case 2:
                                typeOfShip(2,start,value,position);
                                break;
                            case 3:
                                typeOfShip(3,start,value,position);
                                break;
                            case 4:
                                typeOfShip(4,start,value,position);
                                break;
                            default:
                                System.out.println("Wrong syntax");
                        }
                        break;
                    case 7:
                        System.out.println("2) BattleShip (4)\n3) Cruiser (3)\n4) Destroyer (2)");
                        type = in.nextInt();
                        switch (type){
                            case 2:
                                typeOfShip(2,start,value,position);
                                break;
                            case 3:
                                typeOfShip(3,start,value,position);
                                break;
                            case 4:
                                typeOfShip(4,start,value,position);
                                break;
                            default:
                                System.out.println("Wrong syntax");
                        }
                        break;
                    case 8:
                        System.out.println("3) Cruiser (3)\n4) Destroyer (2)");
                        type = in.nextInt();
                        switch (type){
                            case 3:
                                typeOfShip(3,start,value,position);
                                break;
                            case 4:
                                typeOfShip(4,start,value,position);
                                break;
                            default:
                                System.out.println("Wrong syntax");
                        }
                        break;
                    case 9:
                        System.out.println("Destroyer set");
                        typeOfShip(9,start,value,position);
                        //set destroyer
                        break;
                    default:
                        System.out.println("Wrong syntax");
                }
            }
    }
}
