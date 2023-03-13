import java.util.Scanner;

public class DemoRunners {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Machine machine = new Machine();
        Athlete athlete = new Athlete();
        PoliticalCandidate politicalCandidate = new PoliticalCandidate();

        System.out.println("Definition of the Word RUN in different Contexts");
        System.out.println("[1] Machine");
        System.out.println("[2] Athlete");
        System.out.println("[3] Political Candidate");
        System.out.print("Choose a word to define: ");
        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.print("Machine running - ");
            machine.run();
        }
        else if (choice == 2) {
            System.out.print("Athlete running - ");
            athlete.run();
        }
        else if (choice == 3) {
            System.out.print("Political Candidate running - ");
            politicalCandidate.run();
        }
        
        


    }
}
