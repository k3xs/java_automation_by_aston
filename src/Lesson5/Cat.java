package Lesson5;

public class Cat extends Animal {
    private String color;
    private boolean hungry;
    private static int catCount = 0;

    public Cat(String name, String color) {
        super(name);
        this.color = color;
        this.runLimit = 200;
        this.swimLimit = 0;
        this.hungry = false;
        catCount++;
    }


    public void eat(Bowl bowl, int amount) {
        if (hungry) {
            System.out.println(name + " уже сыт(а) и не хочет есть!");
            return;
        }

        System.out.print(name + " пытается съесть " + amount + " еды... ");

        if (bowl.takeFood(amount)) {
            hungry = true;
            System.out.println(name + " насытился!");
        } else {
            System.out.println(name + " остался голодным.");
        }
    }

    public boolean isFull() {
        return hungry;
    }

    public void displaySatiety() {
        System.out.println(name + ": " + (hungry ? "сыт(а)" : "голоден(на)"));
    }

    public static int getCatCount() {
        return catCount;
    }
}
