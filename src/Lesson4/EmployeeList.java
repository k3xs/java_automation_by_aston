//Создать массив из 5 сотрудников.
//Пример:
//вначале объявляем массив объектов Person[] persArray = new Person[5];
//потом для каждой ячейки массива задаем объект
//persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000,30);
//persArray[1] = new Person(...);
//...
//persArray[4] = new Person(...);
package Lesson4;

public class EmployeeList {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];

        persArray[0] = new Employee("Иван",
                "Иванов",
                "Иванович",
                "Developer",
                "ivandev@example.ru",
                "89995060123",
                175500,
                35);

        persArray[1] = new Employee("Сергей",
                "Петров",
                "Аркадьевич",
                "AQA",
                "petrovaqa@example.ru",
                "899950450123",
                155500,
                30);

        persArray[2] = new Employee("Лев",
                "Семенов",
                "Иванович",
                "CTL",
                "semenooff@example.ru",
                "89995060323",
                125500,
                36);

        persArray[3] = new Employee("Михаил",
                "Задорожный",
                "Степанович",
                "Developer",
                "devmzs@example.ru",
                "89995061223",
                175500,
                33);

        persArray[4] = new Employee("Владимир",
                "Витальевич",
                "Степанов",
                "Manager",
                "stsalemanager@example.ru",
                "88895060123",
                100500,
                34);


        for (int i = 0; i < persArray.length; i++) {
            persArray[i].printInfo();
        }
    }
}
