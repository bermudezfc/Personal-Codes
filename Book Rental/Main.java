import java.util.*;

public class Main {
    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        Books[] books = {
            new Books("After Dark", "Murakami", 2016, 2),
            new Books("1984", "Orwell", 1985, 3),
            new Books("Meditations", "Aurelius", 300, 4),
        };

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Electronic Book Rental System");
            System.out.println("=============================");

            // for i is 0 and until i is less than the length of books array
            // increment i
            for (int i = 0; i != books.length; i++) {
                System.out.println(i + " "+ books[i].getTitle() + ", " + books[i].getAuthor());
            }
            System.out.println("=============================");
            System.out.println("Choose a number to rent your favorite book:");
            int choice = scan.nextInt();

            books[choice].borrowBook();

            // to check if index is within range
            try {
                if (choice < 0 || choice >= books.length) {
                    System.out.println("INDEX DOES NOT EXIST. Try Again!");
                    System.out.println();
                }
                else {
                    System.out.println("You rented " + books[choice].getTitle());
                    System.out.println("Rent again? Y/N");

                    String again = scan.nextLine();
                    again = scan.nextLine();
                    if (again.equals("Y")) {
                        run();
                    }
                    else if (again.equals("N")) {
                        break;
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Error Occured");
            }
        }
    }
}








// import java.util.*;
// public class Main {

//     public static void main(String[] args) {
//      Books[] books = {
//         new Books("After Dark", "Murakami", 2016, 2),
//         new Books("1984", "Orwell", 1985, 3),
//         new Books("Meditations", "Aurelius", 300, 4),
//      };

//      Scanner scan = new Scanner(System.in);

     
     

//      while (true){

        
//         System.out.println("Electronic Book Rental System");
//         System.out.println("=============================");

//         // for i is 0 and until i is less than the length of books array
//         // increment i
//         for (int i = 0; i != books.length; i++) {
//             System.out.println(i + " "+ books[i].getTitle() + ", " + books[i].getAuthor());
            
//         }
//         System.out.println("=============================");
//         System.out.println("Choose a number to rent your favorite book:");
//         int choice = scan.nextInt();

//         books[choice].borrowBook();

        
//         // to check if index is within range
//         try {
            
      
//         if (choice < 0 || choice > books.length) {
//             System.out.println("INDEX DOES NOT EXIST. Try Again!");
//             System.out.println();

//         }
//         else{
//             System.out.println("You rented " + books[choice].getTitle());
//             System.out.println("Rent again? Y/N");

//             }
//             String again = scan.nextLine();
//             scan.nextLine();
//             if (again.equals("Y")) {
//                 main(args);
//             }
//             else if(again.equals("N")){
//                 break;
//         }
//         break;
//     } catch (Exception e) {
//         System.out.println("Error Occured");
//     }

//      }
//     }
// }
    



