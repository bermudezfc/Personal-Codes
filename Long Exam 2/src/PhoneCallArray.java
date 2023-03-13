public class PhoneCallArray {
    public static void main(String[] args) {
        PhoneCall[] phoneCalls = new PhoneCall[10];
        phoneCalls[0] = new IncomingPhoneCall("09158529891");
        phoneCalls[1] = new IncomingPhoneCall("09158542891");
        phoneCalls[2] = new IncomingPhoneCall("09155429891");
        phoneCalls[3] = new IncomingPhoneCall("09158529661");
        phoneCalls[4] = new IncomingPhoneCall("09128529891");
        phoneCalls[5] = new OutgoingPhoneCall("09329528391", 3);
        phoneCalls[6] = new OutgoingPhoneCall("09325328391", 4);
        phoneCalls[7] = new OutgoingPhoneCall("09329574391", 1);
        phoneCalls[8] = new OutgoingPhoneCall("09329528721", 8);
        phoneCalls[9] = new OutgoingPhoneCall("09326628391", 10);

        for (PhoneCall phoneCall: phoneCalls){
            System.out.println(phoneCall.getCallInfo());
            System.out.println();
        }


    }
}
