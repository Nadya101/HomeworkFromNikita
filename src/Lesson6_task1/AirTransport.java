package Lesson6_task1;

public abstract class AirTransport extends Transport {
    float wingspan;
    int minRunwayLength;

    //конструктор
    public AirTransport(int powerHours, int maxSpeed, String brand, float weight,   //унаследование поля
                        float wingspan, int minRunwayLength) {              // поля экземпляров єтого класа
        super(powerHours, maxSpeed, brand, weight);   //супер дает возможость доступу к конструктру класса предка
        this.wingspan = wingspan;
        this.minRunwayLength = minRunwayLength;
    }

    //обязательно к наследованию, описание
    public abstract String getDescription();

}
