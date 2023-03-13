public class ScentedCandle extends Candle{
    
    private String scent;

    // public void ScentedCandle(String color, double height, String scent){
    //     this.scent = scent;


    // }
    //setter
    public void setScent(String scent){
        this.scent = scent;
    }

    public String getScent(){
        return scent;
    }

    public void setHeight(Double height){
        super.setHeight(height);
        this.price = 3 * height;
    }


}
