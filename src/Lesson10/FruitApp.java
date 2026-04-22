package Lesson10;

// Main.java
public class FruitApp {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());

        System.out.println("Вес яблок: " + appleBox.getWeight());     // 2.0
        System.out.println("Вес апельсинов: " + orangeBox.getWeight()); // 1.5
        System.out.println("Вес одинаков? " + appleBox.compare(orangeBox)); // false
    }
}
