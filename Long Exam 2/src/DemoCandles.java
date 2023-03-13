import java.util.Scanner;

public class DemoCandles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Hails Candles");
        System.out.print("What color candle would you like? ");
        String color = scan.nextLine();
        System.out.print("How tall in inches do you want your candle? ");
        Double tall = scan.nextDouble();
        scan.nextLine();
        System.out.print("Is your candle regular or scented? ");
        String scented = scan.nextLine();
        

        if (scented.equalsIgnoreCase("Regular")) {
            Candle candle = new Candle();
            candle.setColor(color);
            candle.setHeight(tall);
            System.out.println("=======Your Order========");
            System.out.println("Regular Candle");
            System.out.println("Color: " + candle.getColor());
            System.out.println("Height: " + candle.getHeight() + " inches");
            System.out.println("Price: $" + candle.getPrice());
            System.out.println("=========================");

        }
        else if (scented.equalsIgnoreCase("Scented")) {
            System.out.print("What scent would you like? ");
            String scent = scan.nextLine();

            
            ScentedCandle scentedCandle = new ScentedCandle();
            scentedCandle.setColor(color);
            scentedCandle.setHeight(tall);
            scentedCandle.setScent(scent);
            System.out.println("=======Your Order========");
            System.out.println("Scented Candle");
            System.out.println("Color: " + scentedCandle.getColor());
            System.out.println("Height: " + scentedCandle.getHeight() + " inches");
            System.out.println("Scent: " + scentedCandle.getScent());
            System.out.println("Price: $" + scentedCandle.getPrice());
            System.out.println("=========================");

        }




        // Candle scent1 = new Candle();
        // ScentedCandle scented1 = new ScentedCandle();
        // scent1.setColor("white");
        // scent1.setHeight(2.0);
        // System.out.println(scent1.getPrice());

        // scented1.setHeight(3.0);
        // System.out.println(scented1.getPrice());

    }
}
