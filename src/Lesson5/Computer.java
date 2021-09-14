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
    boolean procesor; //поля екзепляров
    boolean operativka;
    boolean zorstkijDisk;
    int resursPolnogoCykluRaboty;
    boolean isOn = false; //даю по умолчанию false чтобы пометять когда включается
    boolean isDead = false; //даю по умолчанию false чтобы пометять когда сгорает компьютер


    //перегружений конструктор
    public Computer(boolean procesor, boolean operativka, boolean zorstkijDisk, int resursPolnogoCykluRaboty) {
        this.procesor = procesor;
        this.operativka = operativka;
        this.zorstkijDisk = zorstkijDisk;
        this.resursPolnogoCykluRaboty = resursPolnogoCykluRaboty;
    }

    //метод который выводить инфо про компьютер на консоль
    void opisanie() {
        System.out.print("[");
        System.out.print("Процесор: " + procesor + ", оперативка: " + operativka + ", жесткий диск: " + zorstkijDisk + ", ресурс полных циклов работы: " + resursPolnogoCykluRaboty);
        System.out.print("]\n");
    }

    //проверяем на сбой
    boolean proverkaNaZboj() {
        int randomNum = random.nextInt(2); //получаем 0 или 1 случайно
        System.out.print("Введите число 0 или 1 -> ");
        int userNum = scanner.nextInt();               //с клавиатури получаем 0 или 1
        if (randomNum == userNum) {                   //если рандмное число и число пользователя совпадает вызов метода включить компьютер
            System.out.println("Проверка прошла успешно!");
            isDead = false;
        } else {                                                      //если рандмное число и число пользователя не совпадает
            resursPolnogoCykluRaboty = 0;                    //обнуляем цикли
            isDead = true;                                               //компьютер умер потому что не прошел проверку
            System.out.print("Компьютер сгорел. ");
            System.out.println(resursPolnogoCykluRaboty + "-> остаточный ресурс полного циклу компьютера.");
        }
        return isDead;
    }

    boolean vkluchytComputer() {
        proverkaNaZboj();  //вызов метода проверки
        if (procesor & operativka & zorstkijDisk & resursPolnogoCykluRaboty > 0 & (!isOn) & (!isDead)) {//проверяем все ли исправно
            isOn = true;                   //включаем компьютер
            System.out.println("Вы включили компьютер!");
        } else if (resursPolnogoCykluRaboty == 0 & (!isDead)) {   //проверка успешна, но циклы закончились поэтому умер
            isDead = true; //компьютер умер
            isOn = false;  // не может быть включен
            System.out.println("Превышение лимита ресурса, компьютер умер :(");
        } else if (isOn) {
            System.out.println("Компьютер уже был включен!");
        } else {
            System.out.println("Невозможно включить компьютер :(");
        }
        return isOn;
    }

      boolean vykluchytComputer() {
        proverkaNaZboj(); //вызов метода проверки
        if (isOn & (!isDead)) {  //только если компьютер включен и не умер
            isOn = false;               //выключаем
            System.out.println("Компьютер выключен вами!");
            --resursPolnogoCykluRaboty;   //уменьшаем цикл работи на 1 при каждом выключении
        } else {
            System.out.println(":(");
        }
        System.out.println(resursPolnogoCykluRaboty + "-> остаточный ресурс полного циклу компьютера.");
        return isOn;
    }
}
