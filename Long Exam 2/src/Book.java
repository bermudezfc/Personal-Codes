public abstract class Book {
    String bookTitle;
    double bookPrice;

    public Book(String bookTitle){
        this.bookTitle = bookTitle;
    }

    public String getTitle(){
        return bookTitle;
    }
    public double getPrice(){
        return bookPrice;
    }

    public abstract void setPrice();

}
