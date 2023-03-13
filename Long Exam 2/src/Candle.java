public class Candle {
    String color;
    double height;
    double price;

    // getters
    public String getColor(){
        return color;
    }
    public double getHeight(){
        return height;
    }
    public double getPrice(){
        return price;
    }

    //constructor
    // public void Candle(String color, double height){
    //     this.color = color;
    //     setHeight(height);
    // }

    public void setColor(String color){
        this.color = color;
    }

    public void setHeight(Double height){
        this.height = height;
        this.price = 2 * height;
    }
    
}
