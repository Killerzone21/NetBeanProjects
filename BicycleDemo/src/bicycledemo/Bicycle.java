package bicycledemo;

class Bicycle {
    
    private int cadence = 0;
    private int speed = 0;
    private int gear = 1;
    
    public void changeCadence(int newValue){
        cadence = newValue;
    }
    public void changeGear(int NewValue){
        gear = NewValue;
    }
    public void speedUp(int increment){
        speed = speed + increment;
    }
    public void applyBrakes(int decrement){
        speed = speed - decrement;
    }
    public void printStates(){
        System.out.println("cadence:" + cadence + " Speed:" + speed + " gear:" + gear);
        
    }
}
