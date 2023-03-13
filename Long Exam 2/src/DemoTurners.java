import java.util.Scanner;

public class DemoTurners {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Leaf leaf = new Leaf();
        Page page = new Page();
        Pancake pancake = new Pancake();

        System.out.println("OBJECT TURNER");
        System.out.println("[1] Leaf");
        System.out.println("[2] Page");
        System.out.println("[3] Pancake");
        System.out.print("Choose an object to turn: ");
        int choice = scan.nextInt();

        if (choice == 1) {
            leaf.turn();
        }
        else if (choice == 2) {
            page.turn();
        }
        else if (choice == 3) {
            pancake.turn();
        }
        
      
    }
}
