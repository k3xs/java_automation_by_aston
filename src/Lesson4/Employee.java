//Создать класс "Сотрудник" с полями:
//ФИО, должность, email, телефон, зарплата, возраст.
//Конструктор класса должен заполнять эти поля при создании объекта.
//Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

package Lesson4;

public class Employee {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String post;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Employee(String firstName,
                    String lastName,
                    String patronymic,
                    String post,
                    String email,
                    String telephone,
                    int salary,
                    int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Информация о сотруднике:");
        System.out.println("ФИО: " + lastName + " " + firstName + " " + patronymic);
        System.out.println("Должность: " + post);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + telephone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println("_________________________");

    }

    public static void main(String[] args) {
        Employee person = new Employee(
                "Иван",
                "Иванов",
                "Иванович",
                "Developer",
                "ivandev@example.ru",
                "89995060123",
                175500,
                35);

        person.printInfo();
    }
}
