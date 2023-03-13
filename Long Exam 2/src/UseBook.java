public class UseBook {
    public static void main(String[] args) {
        Fiction fiction1 = new Fiction("Norwegian Wood");
        NonFiction nonFiction1 = new NonFiction("Meditations");

        System.out.println("=================");
        System.out.println("Fiction Book");
        System.out.println("Title: " + fiction1.getTitle());
        System.out.println("Price: " + fiction1.getPrice());
        System.out.println("=================");
        System.out.println("Non-Fiction Book");
        System.out.println("Title: " + nonFiction1.getTitle());
        System.out.println("Price: " + nonFiction1.getPrice());
        System.out.println("=================");

    }
}
