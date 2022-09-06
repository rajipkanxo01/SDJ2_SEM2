package phone;

public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
//        phone.receiveMessage("HELLO");
//        phone.setState(new VibrateState());
        phone.volumeUpButton();
        phone.volumeUpButton();
        phone.volumeUpButton();
        phone.volumeUpButton();
        System.out.println(phone.getVolume());
        phone.receiveCall();

        phone.volumeDownButton();
        phone.volumeDownButton();
        phone.volumeDownButton();


        System.out.println(phone.getVolume());
        phone.receiveCall();

        phone.volumeDownButton();
        System.out.println(phone.getVolume());
        phone.receiveCall();

        phone.volumeUpButton();
        phone.volumeUpButton();
        phone.volumeUpButton();
        phone.volumeUpButton();
        System.out.println(phone.getVolume());
        phone.receiveCall();

        System.out.println( "\nVibrate State");
        phone.setState(new VibrateState());
        phone.receiveCall();

    }
}
