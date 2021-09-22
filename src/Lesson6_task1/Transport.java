package Lesson6_task1;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import java.util.Scanner;

public abstract class Transport {
    int powerHours;
    int maxSpeed;
    float weight;
    String brand;
    static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    //конструктор
    public Transport(int powerHours, int maxSpeed, String brand, float weight) {
        this.powerHours = powerHours;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.brand = brand;
    }

    //Расчёт мощности в киловаттах
    public float getPowerKw() {
        return this.powerHours * 0.75f;
    }

    abstract String getDescription();

}
