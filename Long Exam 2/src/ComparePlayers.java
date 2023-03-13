public class ComparePlayers extends Player{
    
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();

        System.out.println("====================");
        System.out.println("ENTER PLAYER 1 INFO");
        player1.readPlayer();
        System.out.println("====================");
        System.out.println("ENTER PLAYER 2 INFO");
        player2.readPlayer();
        System.out.println("====================");

        System.out.println(equals(player1, player2));
        
        
    }

    public static boolean equals(Player p1, Player p2){
        return p1.team.equalsIgnoreCase(p2.team) && p1.jerseyNumber == (p2.jerseyNumber);
    }
}
