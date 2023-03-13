public class DemoHorses {
    public static void main(String[] args) {

        RaceHorse raceHorse1 = new RaceHorse();
        Horse horse1 = new Horse();

        raceHorse1.setName("Grace's Secret");
        raceHorse1.setColor("White");
        raceHorse1.setBirthYear(1973);
        raceHorse1.setNumofRaces(3);

        System.out.println("================");
        System.out.println("Horse type: Race Horse");
        System.out.println("Name: " + raceHorse1.getName());
        System.out.println("Color: " + raceHorse1.getColor());
        System.out.println("Birth Year: " + raceHorse1.getBirthYear());
        System.out.println("Races: " + raceHorse1.getNumofRaces());


        horse1.setName("Lagertha");
        horse1.setColor("Black");
        horse1.setBirthYear(1980);
        System.out.println("================");
        System.out.println("Horse type: Regular Horse");
        System.out.println("Horse");
        System.out.println("Name: " + horse1.getName());
        System.out.println("Color: " + horse1.getColor());
        System.out.println("Birth Year: " + horse1.getBirthYear());
        System.out.println("================");


    }
}
