class Ships {

    //Ships
    private int[] aircraftCarrier ={ 1 , 2 , 3 , 4 , 5};
    private int[] battleship = { 1 , 2 , 3 , 4 };
    private int[] cruiser = { 1 , 2 , 3 };
    private int[] destroyer = { 1 , 2};
    //Ships Locations
    private int locationOAircraftCarrier = 0;
    private int locationOfBattleship = 1;
    private int locationOfCruiser = 3;
    private int locationOfDestroyer = 4;

    //Checking hits
    boolean getHit(int column, int row){
        if(column == locationOAircraftCarrier){
            for(int num : aircraftCarrier){
                if(num == row)
                    return true;
            }
        }else if(column == locationOfBattleship){
            for(int num : battleship){
                if(num == row)
                    return true;
            }

        }else if(column == locationOfCruiser){
            for(int num : cruiser){
                if(num == row)
                    return true;
            }

        }else if(column == locationOfDestroyer){
            for(int num : destroyer){
                if(num == row)
                    return true;
            }
        }return false;
    }

    //Set
    public void setAircraftCarrier(int[] aircraftCarrier) {
        this.aircraftCarrier = aircraftCarrier;
    }

    public void setBattleship(int[] battleship) {
        this.battleship = battleship;
    }

    public void setCruiser(int[] cruiser) {
        this.cruiser = cruiser;
    }

    public void setDestroyer(int[] destroyer) {
        this.destroyer = destroyer;
    }

    public void setLocationOAircraftCarrier(int locationOAircraftCarrier) {
        this.locationOAircraftCarrier = locationOAircraftCarrier;
    }

    public void setLocationOfBattleship(int locationOfBattleship) {
        this.locationOfBattleship = locationOfBattleship;
    }

    public void setLocationOfCruiser(int locationOfCruiser) {
        this.locationOfCruiser = locationOfCruiser;
    }

    public void setLocationOfDestroyer(int locationOfDestroyer) {
        this.locationOfDestroyer = locationOfDestroyer;
    }


}
