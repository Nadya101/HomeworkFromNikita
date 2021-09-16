package Lesson5;

import java.util.Random;
import java.util.Scanner;

/*
Задание:
Создать класс компьютер.
isOn boolean
- процессор Boolean
- оперативкаBoolean
- жесткий диск Boolean
- ресурс полных циклов работы (включений/выключений) int
Методы:
- метод описание(вывод всех полей)
вывод: [“есть”, “есть”, “есть”, 18 циклов]
- метод включить, при включении может произойти сбой, при вызове метода
рандом загадывает число (0 либо 1), вы вводите число с клавиатуры, если
угадали комп включается, если нет сгорает. Если комп сгорел, при попытке
включить нужно выдать сообщение что ему конец
- выключить (аналогично включению)
- при превышении лимита ресурса комп сгорает
 */
public class Computer {
    static Random random = new Random(); //статичесткие чтобы видеть по всему класу
    static Scanner scanner = new Scanner(System.in);
    boolean cpu; //поля екземпляров
    boolean ram;
    boolean hdd;
    int maxNumberOfShutdowns;
    boolean isOn = false; //даю по умолчанию false чтобы пометять когда включается
    boolean isDead = false; //даю по умолчанию false чтобы пометять когда сгорает компьютер


    //перегружений конструктор
    public Computer(boolean cpu, boolean ram, boolean hdd, int MaxNumberOfShutdowns) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.maxNumberOfShutdowns = MaxNumberOfShutdowns;
    }

    //метод который выводить инфо про компьютер на консоль
    void getDescription() {
        System.out.print("[");
        System.out.print("Процесор: " + cpu + ", оперативка: " + ram + ", жесткий диск: " + hdd + "," +
                " ресурс полных циклов работы: " + maxNumberOfShutdowns);
        System.out.println("]");
    }

    //проверяем на сбой
    boolean CheckingForFailure() {
        int randomNum = random.nextInt(2); //получаем 0 или 1 случайно
        System.out.println("Введите число 0 или 1 -> ");
        int userNum = scanner.nextInt();               //с клавиатури получаем 0 или 1
        if (randomNum == userNum) {                   //если рандмное число и число пользователя совпадает вызов метода включить компьютер
            System.out.println("Проверка прошла успешно!");
            isDead = false;
        } else {                                                      //если рандмное число и число пользователя не совпадает
            maxNumberOfShutdowns = 0;                    //обнуляем цикли
            isDead = true;                                               //компьютер умер потому что не прошел проверку
            System.out.print("Компьютер сгорел. ");
            System.out.println(maxNumberOfShutdowns + "-> остаточный ресурс полного циклу компьютера.");
        }
        return isDead;
    }

    boolean onComputer() {
        CheckingForFailure();
        if (!cpu || !ram || !hdd || maxNumberOfShutdowns == 0 || (isDead)) {//проверяем если хоть что-то не исправно
            System.out.println("Невозможно включить компьютер :(");
            isOn = false;
            getDescription();
        } else if (isOn) {
            System.out.println("Компьютер уже был включен!");
        } else {
            isOn = true;
            System.out.println("Компьютер включен!");
        }
        return isOn;
    }

    boolean offComputer() {
        CheckingForFailure(); //вызов метода проверки
        if (isOn && (!isDead)) {  //только если компьютер включен и не умер
            isOn = false;               //выключаем
            System.out.println("Компьютер выключен вами!");
            --maxNumberOfShutdowns;   //уменьшаем цикл работи на 1 при каждом выключении
        } else {
           System.out.println("Компьютер не был выключен.");
        }
        return isOn;
    }
}
