import java.util.Scanner;
public class Arrays {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        //Arrays for the email, usernames, and passwords
        String emails[] = {"fortunebermudez50@gmail.com", "angelobermudez@gmail.com", "gabbybermudez@gmail.com", "rgcbrmdz@gmail.com", "rowenabermudez@gmail.com"};
        String usernames[] = {"tommydon69", "angelow", "brownie", "chikalogs", "whites"};
        String passwords[] = {"iloveshabs", "iloveaira", "ilovedogs", "matakawako", "sugatanako"};

        // Displaying the current saved informations for each user

        System.out.println("Credential Saver");
        System.out.println();

        System.out.println("Corresponding Index for Users");
        System.out.println("0 for Fortune Bermudez");
        System.out.println("1 for Angelo Bermudez");
        System.out.println("2 for Gabby Bermudez");
        System.out.println("3 for Gail Bermudez");
        System.out.println("4 for Rowena Bermudez");
        System.out.println();

        // Input of Index and assigning of scanner to printed informations

        System.out.print("Enter Index: ");
        int z = scan.nextInt();



        // Printing of Information

        System.out.println();
        System.out.println("Email: " + emails[z]);
        System.out.println("Username: " + usernames[z]);
        System.out.println("Password: " + passwords[z]);







    
    }
}
