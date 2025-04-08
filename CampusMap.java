import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));

       // Using full constructor (name, address, floors)
       myMap.addBuilding(new Building("Ford Hall", "100 Green Street, Northampton, MA 01063", 4));
       myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court, Northampton, MA 01063", 4));
       myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive, Northampton, MA 01063", 3));
       myMap.addBuilding(new Building("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5));
       myMap.addBuilding(new Building("Sage Hall", "144 Green Street, Northampton, MA 01063", 4));
       myMap.addBuilding(new Building("McConnell Hall", "5 Chapin Drive, Northampton, MA 01063", 4));

       // Using overloaded constructor (name, address) - defaults to 1 floor
       myMap.addBuilding(new Building("Sabin-Reed Hall", "42 College Lane, Northampton, MA 01063"));
       myMap.addBuilding(new Building("Hatfield Hall", "Northampton, MA 01063"));
       myMap.addBuilding(new Building("John M. Greene Hall", "60 Elm Street, Northampton, MA 01063"));
       myMap.addBuilding(new Building("Mendenhall Center", "122 Green Street, Northampton, MA 01063"));
       myMap.addBuilding(new Building("Lyman Conservatory", "16 College Lane, Northampton, MA 01063"));
       myMap.addBuilding(new Building("Smith College Museum of Art", "20 Elm Street, Northampton, MA 01063"));

        //House using overloaded constructor, floor is 1
       House chaseHouse = new House("Chase House", "10 Elm Street, Northampton, MA 01063");
       myMap.addBuilding(chaseHouse);
   
       // Library
       Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5);
       neilson.addTitle("Pride and Prejudice");
       neilson.addTitle("The Great Gatsby", false); // using overloaded method
       myMap.addBuilding(neilson);
   
       // Cafe
       Cafe compassCafe = new Cafe("Compass Cafe", "Neilson Library, Ground Floor",1);
       compassCafe.sellCoffee(2, 1, 1); // using a method in Cafe
       myMap.addBuilding(compassCafe);


        System.out.println(myMap);

    }
    
}
