package Lesson5;

public class AnimalApp {
    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик", "коричневый");
        Cat murka = new Cat("Мурка", "белая");
        Dog rex = new Dog("Рекс", "черный");

        bobik.run(150);
        bobik.run(600);
        bobik.swim(5);
        bobik.swim(15);

        murka.run(150);
        murka.run(250);
        murka.swim(5);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}
