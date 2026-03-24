package Lesson5;

public class ShapeApp {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0, "Желтый", "Оранжевый");
        Shape rectangle = new Rectangle(4.0, 6.0, "Голубой", "Синий");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Зеленый", "Темно-зеленый");


        System.out.println("=== Информация о фигурах ===\n");

        System.out.println("Круг:");
        circle.printInfo();

        System.out.println("Прямоугольник:");
        rectangle.printInfo();

        System.out.println("Треугольник:");
        triangle.printInfo();

        System.out.println("=== Меняем цвет круга ===\n");
        circle.setFillColor("Красный");
        circle.setBorderColor("Бордовый");
        System.out.println("Круг после смены цвета:");
        circle.printInfo();
    }
}
