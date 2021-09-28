package Lesson6_task1;

public class MilitaryAirTransport extends AirTransport {
    boolean isCatapult;
    int countRocket;

    //конструктор
    public MilitaryAirTransport(int powerHours, String brand, int maxSpeed, int minRunwayLength,
                                float weight, float wingspan, int countRocket, boolean isCatapult) {
        super(powerHours, maxSpeed, brand, weight, wingspan, minRunwayLength);
        this.countRocket = countRocket;
        this.isCatapult = isCatapult;
    }

    @Override
    public String getDescription() {
        return  "Марка " + this.brand + ":\n-Мощность " + this.powerHours + " лошадиных сил;\n-Мощность " + getPowerKw() + " кВ;\n" +
                "-Максимальная скорость " + this.maxSpeed + " км/ч;\n-Масса " + this.weight + " кг;\n" +
                "-Размах крыльев " + this.wingspan + " м;\n-Минимальная длина взлётно-посадочной полосы для взлёта " + this.minRunwayLength + " м;" +
                "\n-" + checkCatapultSystem() + "\n-Количество ракет на борту - " + this.countRocket + " штук.\n";
    }

    //метод для описание с-ми катапультирования
    public String checkCatapultSystem() {
        if (this.isCatapult) {
            return "Система катапультирования есть на борту;";
        }
        else {
            return "Системы катапультирования отсутсвует;";
        }
    }

    //делаем метод выстрел, проверяем кол-во ракет
    public void startRocket() {
        if (this.countRocket != 0) {
            System.out.println("Ракета пошла...!");
        }
        else {
            System.out.println("Боеприпасы отсутствуют.");
        }
    }


    public void useCatapult() {
        if (this.isCatapult) {
            System.out.println("Катапультирование прошло успешно.");
        }
        else {
            System.out.println("У вас нет такой системы.");
        }
    }

    public void hulkAttack() {
        if (this.countRocket >= 20) {
            startRocket();
        } else if (this.isCatapult) {
            System.out.print("Недостаточно ракет((( ");
            useCatapult();
        } else {
            System.out.println("ХАЛК ЗЛОЙ!!");
        }
    }

}
