package Lesson6_task1;

/*
Task 1 -> Разработать иерархию классов подобную схеме:
В классе Транспорт есть поля:
- Мощность(в лошадиных силах)
- Максимальная скорость(км/ч)
- Масса (кг)
- Марка( например: Audi, BMW , Boing, Airbus, Scania , МАЗ и т.д. )
В классе Наземный добавляются поля:
-Количество колёс
- Расход топлива(л/100км)
В классе Легковой добавляются поля:
- Тип кузова
- Кол-во пассажиров
В классе Грузовой добавляется поле:
- Грузоподъёмность(т)
В классе Воздушный добавляются поля:
- Размах крыльев (м)
- Минимальная длина взлётно-посадочной полосы для взлёта
В классе Гражданский добавляются поля:
- Кол-во пассажиров
- Наличие бизнес класса (true/false)
В классе Военный добавляются поля:
- Наличие системы катапультирования (true/false)
- Кол-во ракет на борту
В конечных классах (Легковой, Грузовой, Военный, Гражданский)
разработать метод описание который будет возвращать составленную строку
с описанием всех характеристик объекта.
В строку включить ещё один параметр мощность в киловаттах (кВ) . Расчёт
мощности в киловаттах производится в отдельном методе: 1 л.с = 0.74 кВ
Для легкового разработать метод который будет принимать время и считать
сколько километров проедет машина двигаясь с максимальной скоростью и
сколько топлива она израсходует за это время, результат вывести в консоль,
расчёт израсходуемого топлива вынести в отдельный метод private.
Результат работы метода должен вывести такую строчку: За время (ваше
введённое время) ч, автомобиль (марка автомобиля) двигаясь с максимальной
скоростью (ваша максимальная скорость) км/ч проедет (xxx) км и израсходует (xxx)
литров топлива.
Пример: За время 2.5 ч, автомобиль Audi двигаясь с максимальной скоростью
230 км/ч проедет 575 км и израсходует 46 литров топлива.
Для грузового разработать метод который проверит можно ли загрузить в
него xxx груза Метод должен проверять если это кол-во груза помещается в грузовик то
выводит в консоль ”Грузовик загружен”, если кол-во груза которое нужно загрузить
больше чем то которое может влезть в наш грузовик то выводим “Вам нужен грузовик
побольше ”.
Такой же метод делаем для Гражданских самолётов, только проверяем
вместимость пассажиров.
Для Военных самолётов делаем метод выстрел, проверяем если кол-во ракет
не равно 0 то выводим на консоль “ Ракета пошла...”, если 0 то “Боеприпасы
отсутствуют”.
А так же метод катапультирование, который проверит если наличие системы
катапультирования true, то выводим “Катапультирование прошло успешно”, если false,
то “У вас нет такой системы
 */
public class MainApplicationL6 {
    public static void main(String[] args) {
        //создаю екзепляри класов
        LightTransport aston = new LightTransport(450, 295, "Aston Martin", 1800, 4,
                10.5f, "седан", 4);
        FreightTransport mega = new FreightTransport(500, 150, 48222, "Mercedes", 8,
                6.64f, 24.5f);
        CivilAirTransport airbus = new CivilAirTransport(111000, 925, "Airbus", 40600,
                34.10f, 350, 156, true);
        MilitaryAirTransport dassault = new MilitaryAirTransport(190726, "Dassault", 2203, 200,
                9060, 10.80f, 7, true);

        //сколько километров проедет машина
        System.out.println("Сколько километров проехал машина?");
        aston.getWay();
        System.out.println(); //пустая строка

        //можно ли загрузить к xxx груза
        System.out.println("Сколько весит груз?");
        mega.checkCargoWeight();
        System.out.println(); //пустая строка

        //проверяем вместимость пассажиров
        System.out.println("Введите количество пассажиров -> ");
        airbus.checkCapacity();
        System.out.println(); //пустая строка


        //наличие системы катапультирования
        dassault.useCatapult();

        // метод выстрел
        dassault.startRocket();


        //внезапна атака Халка :)
        dassault.hulkAttack();
        System.out.println();

        //описание обьэктов
        System.out.println(aston.getDescription());//нужно распечатать метод, так как он только возвращает строку с описанием
        System.out.println(mega.getDescription());
        System.out.println(airbus.getDescription());
        System.out.println(dassault.getDescription());
    }
}
