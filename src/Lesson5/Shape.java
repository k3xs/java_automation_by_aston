//Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
//круг, прямоугольник, треугольник.
//Задать для каждой фигуры цвет заливки и цвет границы.
//Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой
//фигуре вывести в консоль.
//Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве
//дефолтных методов в интерфейсе.

package Lesson5;

public interface Shape {

    String getFillColor();
    String getBorderColor();
    void setFillColor(String color);
    void setBorderColor(String color);


    double getPerimeter();
    double getArea();


    default void printInfo() {
        System.out.println("Тип фигуры: " + getClass().getSimpleName());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("------------------------");
    }
}