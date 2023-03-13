public class DemoPhoneCalls {
    public static void main(String[] args) {
        IncomingPhoneCall inCall = new IncomingPhoneCall("091234");
        OutgoingPhoneCall outCall = new OutgoingPhoneCall("094321", 2);

        System.out.println(inCall.getCallInfo());
        System.out.println();
        System.out.println(outCall.getCallInfo());

    }
    
}
