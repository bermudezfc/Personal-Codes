public class IncomingPhoneCall extends PhoneCall {


    public IncomingPhoneCall(String phoneNumber) {
        super(phoneNumber);
        super.price = 0.02;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCallInfo() {
        String info = ("o=Incoming Call=o\nNumber: "+phoneNumber+"\nRate: "+price + "\nPrice: $"+price);
        return info;    }
    
}
