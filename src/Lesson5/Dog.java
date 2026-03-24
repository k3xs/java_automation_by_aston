package Lesson5;

public class Dog extends Animal {
    private String color;
    private static int dogCount = 0;

    public Dog(String name, String color) {
        super(name);
        this.color = color;
        this.runLimit = 500;
        this.swimLimit = 10;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}
