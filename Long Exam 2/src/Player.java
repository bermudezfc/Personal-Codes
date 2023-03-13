import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);


    String name, team;
    int jerseyNumber;


    public void readPlayer(){

        System.out.print("Player name: ");
        name = scan.nextLine();
        
        System.out.print("Player team: ");
        team = scan.nextLine();
        
        System.out.print("Player Jersey Number: ");
        jerseyNumber = scan.nextInt();
    }


}
