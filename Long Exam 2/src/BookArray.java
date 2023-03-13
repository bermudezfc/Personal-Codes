public class BookArray {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        books[0] = new Fiction("The Great Gatsby");
        books[1] = new Fiction("After Dark");
        books[2] = new Fiction("1Q84");
        books[3] = new Fiction("A song of Fire and Ice");
        books[4] = new Fiction("Kafka on the Shore");
        books[5] = new NonFiction("Man's search for meaning");
        books[6] = new NonFiction("Atomic Habits");
        books[7] = new NonFiction("Letters from a Stoic");
        books[8] = new NonFiction("The Republic");
        books[9] = new NonFiction("Sapiens: A Brief History of Humankind");

        System.out.println("Welcome to Fully Booked");
        System.out.println("Here are our available books: ");
        
        for (Book book : books) {
            System.out.println("===========================");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: Php " + book.getPrice());
            System.out.println("Type: " + (book instanceof Fiction ? "Fiction" : "Non-Fiction"));
        }

        System.out.println("===========================");

    }
}
