package Lesson6_task1;

public class FreightTransport extends LandTransport {
    float loadingCapacity;

    //конструктор
    public FreightTransport(int powerHours, int maxSpeed, float weight, String brand, int countOfWheels,
                            float fuelConsumption, float loadingCapacity) {
        super(powerHours, maxSpeed, brand, weight, countOfWheels, fuelConsumption);
        this.loadingCapacity = loadingCapacity;
    }

    //возвращает строку с описанием всех характеристик объекта
    @Override
    public String getDescription() {
        return "Марка " + this.brand + ":\n-Мощность " + this.powerHours + " лошадиных сил;\n-Мощность " + getPowerKw()
                + " кВ;\n" +"-Максимальная скорость " + this.maxSpeed + " км/ч;\n-Масса " + this.weight + " кг;\n" +
                "-Количество колёс " + this.countOfWheels + ";\n-Расход топлива " + this.fuelConsumption + " л/100км;\n" +
                "-Грузоподъёмность " + this.loadingCapacity + " т.\n";
    }

    //проверить можно ли загрузить в него xxx груза
    public void checkCargoWeight() {
        float cargoWeight = scanner.nextFloat();
        if (cargoWeight < this.loadingCapacity){
            System.out.println("Грузовик загружен.");
        } else {
            System.out.println("Вам нужен грузовик побольше.");
        }
    }
}