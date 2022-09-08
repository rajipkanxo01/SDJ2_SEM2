package computer;

public class RunComputer {
    public static void main(String[] args) {
        Thread mailbox = new Thread(new Mailbox(5));
        Thread program1 = new Thread(new Program("Windows", "update", 5));
        Thread program2 = new Thread(new Program("AVG", "update virus database", 5));
        Thread program3 = new Thread(new Program("FBackup", "perform a scheduled backup", 5));
        Thread program4 = new Thread(new Program("Skype", "notify you about a person logging in", 5));
        System.out.println("---->Turning on the computer");
        program1.start();
        program2.start();
        program3.start();
        program4.start();
        mailbox.start();
    }
}
