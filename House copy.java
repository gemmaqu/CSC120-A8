/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

   //Attributes
   private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
   private boolean hasDiningRoom;

   //Consturctor
  public House(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = true;
    System.out.println("You have built a house: 🏠");
  }
  /**
   * check whether the house has a dining room
   * @return true if the house has dining room, false if not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * get the number of residents in the house
   * @return the number of residents in integer
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * move students in, checking whether the student has already been in the house first, then add the students
   * @param s the student you want to move them in the house
   */
  public void moveIn(Student s){
    if(!this.residents.contains(s)) {
      this.residents.add(s);
      System.out.println(s.getName()+"has moved into the House.");
    }else{
      System.out.println(s.getName()+"has already in the House.");
    }  
  }

  /**
   * move out student , checking whether the student is in the house first
   * @param s the student you want to move out 
   * @return the student if they move out succefully, null if not
   */
  public Student moveOut(Student s){
    if(this.residents.contains(s)){
      this.residents.remove(s);
      System.out.println(s.getName()+"has moved out the House.");
      return s;
    }else{
      System.out.println(s.getName()+"is not in the House.");
      return null;
    }
  }

  /**
   * check whether a student is a resident of the house
   * @param s student you want to check
   * @return true if the student is in the array list of the house, false if not
   */
  public boolean isResident(Student s){
    if(this.residents.contains(s)){
      return true;
    }else{
      return false;
    }
  }
  



  public static void main(String[] args) {
    Student Abby = new Student("Abby", "1234", 2027);
    House Talbot = new House("Talbot", "prospect street 25", 4);
    Talbot.moveIn(Abby);
    Talbot.isResident(Abby);
   
  }

}