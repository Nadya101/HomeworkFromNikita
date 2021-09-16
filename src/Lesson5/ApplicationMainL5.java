package Lesson5;

public class ApplicationMainL5 {
    public static void main(String[] args) {
        Computer mac = new Computer(true, true, true, 3);
        System.out.println("Пройдите проверку для включения компьютера!");
        mac.onComputer();
        if (mac.isOn) {
            System.out.println("Пройдите проверку для выключения компьютера!");
            mac.offComputer();
        }
    }
}
