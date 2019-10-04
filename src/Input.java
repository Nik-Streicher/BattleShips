class Input {

    private Ships sh = new Ships();

    //x =; y =;
    /*private void direction(int dir,int start) {
        if(dir == 1){
            //pole = horizontal;
            //location = vertical;
        }else if(dir == 2){
            //pole = vertical;
            //location = horizontal;

        }else System.out.println("Wrong syntax");
    }
*/
    private void start(int start,int type){
        //change numbers
        switch (start) {
            case 1: case 2: case 3: case 4: case 5:case 6:
                System.out.println("1) AirCraftCarrier (5)\n2) BattleShip (4)\n3) Cruiser (3)\n4) Destroyer (2)");
                switch (type){
                    case 1:
                        typeOfShip(1,start);
                        break;
                    case 2:
                        typeOfShip(2,start);
                        break;
                    case 3:
                        typeOfShip(3,start);
                        break;
                    case 4:
                        typeOfShip(4,start);
                        break;
                    default:
                        System.out.println("Wrong syntax");
                }
                break;
            case 7:
                System.out.println("2) BattleShip (4)\n3) Cruiser (3)\n4) Destroyer (2)");
                switch (type){
                    case 2:
                        typeOfShip(2,7);
                        break;
                    case 3:
                        typeOfShip(3,7);
                        break;
                    case 4:
                        typeOfShip(4,7);
                        break;
                    default:
                        System.out.println("Wrong syntax");
                }
                break;
            case 8:
                System.out.println("3) Cruiser (3)\n4) Destroyer (2)");
                switch (type){
                    case 3:
                        typeOfShip(3,8);
                        break;
                    case 4:
                        typeOfShip(4,8);
                        break;
                    default:
                        System.out.println("Wrong syntax");
                }
                break;
            case 9:
                System.out.println("Destroyer set");
                sh.setDestroyer(9);
                //set destroyer
                break;
            default:
                System.out.println("Wrong syntax");
        }
    }

    private void typeOfShip(int type,int startPosition){
        switch(type){
            case 1:
                sh.setAircraftCarrier(startPosition);
                break;
            case 2:
                sh.setBattleship(startPosition);
                break;
            case 3:
                sh.setCruiser(startPosition);
                break;
            case 4:
                sh.setDestroyer(startPosition);
                break;
            case 5:
                break;
        }
    }
}
