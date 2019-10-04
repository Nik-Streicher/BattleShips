class Ships {

    //Ships
    private int[] aircraftCarrier = new int[5];
    private int[] battleship = new int[4];
    private int[] cruiser = new int[3];
    private int[] destroyer = new int[2];
    //Ships Locations
    private int locationOAircraftCarrier;
    private int locationOfBattleship;
    private int locationOfCruiser;
    private int locationOfDestroyer;

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
    void setAircraftCarrier(int startAircraftCarrier) {
        for(int x = 0; x <aircraftCarrier.length; x++){
            aircraftCarrier[x] = startAircraftCarrier;
            startAircraftCarrier++;

        }
    }

    void setBattleship(int startBattleship) {
        for(int x = 0; x <battleship.length; x++) {
            battleship[x] = startBattleship;
            startBattleship++;
        }
    }

    void setCruiser(int startCruiser) {
            for(int x = 0; x <cruiser.length; x++){
                cruiser[x] = startCruiser;
                startCruiser++;
        }
    }

    void setDestroyer(int startDestroyer) {
            for(int x = 0; x <destroyer.length; x++){
                destroyer[x] = startDestroyer;
                startDestroyer++;
        }
    }

    //Locations
    public void setLocationOAircraftCarrier(int locationOAircraftCarrier) { this.locationOAircraftCarrier = locationOAircraftCarrier; }

    public void setLocationOfBattleship(int locationOfBattleship) {
        this.locationOfBattleship = locationOfBattleship;
    }

    public void setLocationOfCruiser(int locationOfCruiser) {
        this.locationOfCruiser = locationOfCruiser;
    }

    public void setLocationOfDestroyer(int locationOfDestroyer) {
        this.locationOfDestroyer = locationOfDestroyer;
    }

    void writeArray(){
        for(int x: aircraftCarrier)
            System.out.println(x);
    }


}
