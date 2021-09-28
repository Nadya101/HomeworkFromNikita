package Lesson6_task1;


public class LightTransport extends LandTransport {
    String bodyworkType;
    int countPassengers;
    float way;

    //конструктор
    public LightTransport(int powerHours, int maxSpeed, String brand, float weight, int countOfWheels, float fuelConsumption,
                          String bodyworkType, int countPassengers) {
        super(powerHours, maxSpeed, brand, weight, countOfWheels, fuelConsumption);
        this.bodyworkType = bodyworkType;
        this.countPassengers = countPassengers;
        this.way = 00.0f;
    }

    //возвращает строку с описанием всех характеристик объекта
    @Override
    public String getDescription() {
        return "Марка " + this.brand + ":\n-Мощность " + this.powerHours + " лошадиных сил;\n-Мощность " + getPowerKw() + " кВ;\n" +
                "-Максимальная скорость " + this.maxSpeed + " км/ч;\n-Масса " + this.weight + " кг;\n" +
                "-Количество колёс " + this.countOfWheels + ";\n-Расход топлива " + this.fuelConsumption + " л/100км;\n" +
                "-Тип кузова - " + this.bodyworkType + ";\n-Кол-во пассажиров " + this.countPassengers + " человек.\n";
    }

    /* метод который будет принимать время и считать сколько километров проедет машина двигаясь с максимальной скоростью и
     сколько топлива она израсходует за это время, результат вывести в консоль,
     расчёт израсходуемого топлива вынести в отдельный метод private.
 */
    public void getWay() {
       float time = scanner.nextFloat();
        this.way = (float) this.maxSpeed * time;
        System.out.printf("За время  %.1f ч, автомобиль %s двигаясь с максимальной скоростью %d км/ч проедет %.1f км и израсходует %.2f " +
                "литров топлива.\n", time, this.brand, this.maxSpeed, this.way, getTotalFuelConsumption(this.way));
    }

    //рассчитать расход топлива
    private float getTotalFuelConsumption(float way) {
        return way * (this.fuelConsumption / 100);
    }
}