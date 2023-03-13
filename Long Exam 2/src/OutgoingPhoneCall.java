public class OutgoingPhoneCall extends PhoneCall {

    double time;
    double rate = 4.0;    

    public OutgoingPhoneCall(String phoneNumber, double time) {
        super(phoneNumber);
        this.time = time;
        super.price = rate * time;
        
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getPhoneNumber() {
        // TODO Auto-generated method stub
        return phoneNumber;
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        return price;
    }

    @Override
    public String getCallInfo() {
        // TODO Auto-generated method stub
        String info = ("o=Outgoing Call=o\nNumber: "+phoneNumber+"\nRate: "+rate+ "\nMinutes: " + time + "\nPrice: $"+price);
        return info;
    }


    
}
