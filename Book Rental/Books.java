public class Books {

    // Declaration of Attributes with Encapsulation (private)
   private String title;
   private String author;
   private int year;
   private int numOfCopies;

   // Constructor for Books (constructor name should be the same as class)
   public Books(String title, String author, int year, int numOfCopies){
    this.title = title;
    this.author = author;
    this.year = year;
    this.numOfCopies = numOfCopies;
}

    // Getters for attributes
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getYear(){
        return year;
    }
    public int getNumofCopies(){
        return numOfCopies;
    }

    public void borrowBook(){
        if (numOfCopies < 1) {
            System.out.println("No copies available");
        }
        else {
            numOfCopies--;
        }
    }
}

