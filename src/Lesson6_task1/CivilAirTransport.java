package Lesson6_task1;

public class CivilAirTransport extends AirTransport {
    int countPassengers;
    boolean isBusinessClass;

    //конструктор
    public CivilAirTransport(int powerHours, int maxSpeed, String brand, float weight,
                             float wingspan, int minRunwayLength, int countPassengers, boolean isBusinessClass) {
        super(powerHours, maxSpeed, brand, weight, wingspan, minRunwayLength);
        this.countPassengers = countPassengers;
        this.isBusinessClass = isBusinessClass;
    }

    //возвращает строку с описанием всех характеристик объекта
    @Override
    public String getDescription() {
        return "Марка " + this.brand + ":\n-Мощность " + this.powerHours + " лошадиных сил;\n-Мощность " + getPowerKw() + " кВ;\n" +
                "-Максимальная скорость " + this.maxSpeed + " км/ч;\n-Масса " + this.weight + " кг;\n" +
                "-Размах крыльев " + this.wingspan + " м;\n-Минимальная длина взлётно-посадочной полосы для взлёта " + this.minRunwayLength + " м;\n" +
                "-Кол-во пассажиров " + this.countPassengers + ";\n-" + checkBusinessClass() + ".\n";
    }

    //делаем строку для описание бизнес класса
    public String checkBusinessClass() {
        if (this.isBusinessClass) {
            return "Есть бизнес класс";
        }
        else {
            return "Бизнес класc отсутствует";
        }
    }

    // проверяем вместимость пассажиров
    public void checkCapacity() {
        int passengers = scanner.nextInt();
        if (passengers < this.countPassengers) {
            System.out.println("Забронировано " + passengers + " мест в самолете. " +
                    "Осталось " + (this.countPassengers - passengers) + " свободных мест.");
        }
        else if (passengers == this.countPassengers) {
            System.out.println("Все места в самолете забронирование.");
        }
        else {
            System.out.println("Вам нужен самолет побольше.");
        }
    }
}
