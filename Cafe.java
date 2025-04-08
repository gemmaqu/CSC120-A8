/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {


    //attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    //constructor
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 10;
        this.nSugarPackets = 12;
        this.nCreams = 5;
        this.nCups = 100;
        this.hasElevator = false;
        System.out.println("You have built a cafe: ☕");
    }

     /**
     * Constructor with custom initial inventory
     * @param name Name of the cafe
     * @param address Location of the cafe
     * @param nFloors Number of floors in the cafe
     * @param nCoffeeOunces Initial coffee inventory in ounces
     * @param nSugarPackets Initial sugar packets inventory
     * @param nCreams Initial cream inventory
     * @param nCups Initial cups inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = false;
        System.out.println("You have built a cafe with custom inventory: ☕");
    }

    /**
     * Constructor with custom initial inventory and elevator option
     * @param name Name of the cafe
     * @param address Location of the cafe
     * @param nFloors Number of floors in the cafe
     * @param hasElevator Whether the cafe has an elevator
     * @param nCoffeeOunces Initial coffee inventory in ounces
     * @param nSugarPackets Initial sugar packets inventory
     * @param nCreams Initial cream inventory
     * @param nCups Initial cups inventory
     */
    public Cafe(String name, String address, int nFloors, boolean hasElevator, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe with custom inventory and elevator option: ☕");
    }

    /**
     * sell a cup of coffe, but the material in inventory will be reduced as well
     * @param size,nSugarPackets,nCreams the materials you need to use to make a coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("You have "+this.nCoffeeOunces +" Ounces remaining, "+this.nSugarPackets+" packets sugar remaining, "+this.nCreams+" remaining sugar, "+this.nCups+" Cups remaining in inventory.");
    }
    
    /**
     * Sell a cup of coffee with default values (1 sugar packet, 1 cream)
     * @param size The size of the coffee in ounces
     */
    public void sellCoffee(int size) {
        // Default to 1 sugar packet and 1 cream
        sellCoffee(size, 1, 1);
    }

    /**
     * restock the material in inventory
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void showOptions() { //override from the building class
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(size,nSugarPackets,nCreams) \n + restock(nCoffeeOunces,nSugarPackets,nCreams,nCups) \n");
    }


    public void goToFloor(int floorNum) {
        super.goToFloor(floorNum);
         if(this.hasElevator == false){
           System.out.println("Sorry, we don't have elevtaor");
         }
       }    
    
    public static void main(String[] args) {
        Cafe campuscafe = new Cafe("Campus cafe", "campus center first floor", 1);
        campuscafe.sellCoffee(3, 2, 3);
        campuscafe.restock(5, 5, 10, 100);
        campuscafe.showOptions();
        campuscafe.enter();
        campuscafe.goToFloor(1);
    }
    
}
