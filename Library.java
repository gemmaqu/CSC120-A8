/* This is a stub for the Library class */

import java.util.Enumeration;
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {


  //attributes
  private Hashtable<String, Boolean> collection;


    //constructor
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String,Boolean>();//empty hastable
      System.out.println("You have built a library: 📖");
    }
    // Overloaded constructor with default number of floors = 1
    /**
     * constructor with default number of floor n= 1
     * @param name
     * @param address
     */
  public Library(String name, String address) {
    super(name, address, 1);
    this.collection = new Hashtable<String, Boolean>(); // empty hashtable
    System.out.println("You have built a small but mighty library: 📚");
  }
  
    /**
     * add a book to the library by adding its title
     * @param title The tittle we want to add to the library
     */
    public void addTitle(String title){
      if(!this.collection.containsKey(title)){
        this.collection.put(title,true);
        System.out.println(title+"has been addded to our collection.");
      }else{
        System.out.println(title+"has already on our collection.");
      }
    }

    // overloaded method for addTitle
    /**
     * add a book to the library by specifying its title and availability
     * @param title The title we want to add to the library
     * @param isAvailable Whether the book is available for checkout
     */
  public void addTitle(String title, boolean isAvailable){
    if(!this.collection.containsKey(title)){
      this.collection.put(title, isAvailable);
      System.out.println(title + " has been added to our collection. Available: " + isAvailable);
    } else {
      System.out.println(title + " is already in our collection.");
    }
  }


    /**
     * remove a book from the library by removing the book's title
     * @param title The title we want to remove from the library
     * @return the title if removed, null if not
     */

    public String removeTitle(String title){
      if(this.collection.containsKey(title)){
        this.collection.remove("title"); 
        return title;
        }else{
          System.out.println(title+"is not in our collection");
          return null;
        }
    }

    /**
     * check out a book by first checking if the library has the book, then check whether the book is available.
     * @param title the title of the book you want to check out
     */
    public void checkOut(String title){
      if(this.collection.containsKey(title)){
        if (this.collection.get(title)){// to check whether the book is available 
          this.collection.replace(title, false);
          System.out.println(title+"has been succesfully checked out"); 
        } else{
          System.out.println("Sorry"+title+"is already checked out");
      }
      }else{
        System.out.println("Sorry"+title+"is not in our library");
    }
  }

    /**
     * return a book we checked out before by checking if the library has the book at first, then check whether the book has been returned before
     * @param title the title of the book we want to return
     */
    public void returnBook(String title){
      if(this.collection.containsKey(title)){
        if (!this.collection.get(title)){// to check whether the book is checked out by chekcing whether the book is on the library
          this.collection.replace(title, true);
          System.out.println(title+"has been succesfully returned"); 
        } else{
          System.out.println("Sorry,"+title+"is already in our library");
      }
      }else{
        System.out.println("Sorry"+title+"is not part of our collection");
      }
    }


    /**
     * check whether the library has a book by checking its title
     * @param title the title of the book you want to check whether it's in the library
     * @return true if library has the book, false if not.
     */
    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }
    

    /**
     * check whether a book is available by checking whether the library has that book AND whether the book has been checked out
     * @param title the title of the book you want to check whether it's available
     * @return true if the book is available, false if not
     */
    public boolean isAvailable(String title){
     return this.collection.containsKey(title) && this.collection.get(this); //need to check the book EXISTS AND AVAILABLE
    }

    /**
     * print the list of book in the library with their status(available or checked out)
     */
    public void printCollection(){
      System.out.println("\nLibrary Collection:");
      Enumeration<String>titles = this.collection.keys();
      while (titles.hasMoreElements()) {
          String title = titles.nextElement();
          String status = this.collection.get(title) ? "Available" : "Checked Out";
          System.out.println("- " + title + " (" + status + ")");
        }

    }


    public void showOptions() {//override from the Buildng class
      System.out.println("Available options at " + this.name + ":\n + addTitle(String title) \n + returnBook(String title) \n + containsTitle(String title) \n + isAvailable(title)\n + printCollection()");
  }



    public void goToFloor(int floorNum) {
      super.goToFloor(floorNum);
      if(this.hasElevator == false){
        System.out.println("Sorry, we don't have elevtaor");
      }
    }

    public static void main(String[] args) {
      Library Neilson = new Library("Neilson Library", "Neilson way 123", 5);
      Neilson.addTitle("The Little Prince");
      Neilson.addTitle("1984");
      Neilson.addTitle("Gone with the wind");
      Neilson.checkOut("Gone with the wind");
      Neilson.returnBook("Gone with the wind");
      Neilson.printCollection();
      Neilson.showOptions();
      Neilson.enter();
      Neilson.goToFloor(4);
    }
  
  }