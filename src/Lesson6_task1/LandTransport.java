package Lesson6_task1;

public abstract class LandTransport extends Transport {
    int countOfWheels;
    float fuelConsumption;

    //конструктор
    public LandTransport(int powerHours, int maxSpeed, String brand, float weight,   //унаследование поля
                         int countOfWheels, float fuelConsumption) {              // поля экземпляров этого класа
        super(powerHours, maxSpeed, brand, weight);   //супер дает возможность доступу к конструктору класса предка
        this.countOfWheels = countOfWheels;
        this.fuelConsumption = fuelConsumption;
    }

    //обязательно к наследованию, описание
    public abstract String getDescription();
}
