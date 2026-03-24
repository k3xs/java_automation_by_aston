package Lesson5;

public class CatApp {
    public static void main(String[] args) {

        Bowl bowl = new Bowl(30);
        System.out.println("=== Создана миска ===");
        bowl.displayInfo();
        System.out.println();


        Cat[] cats = {
                new Cat("Барсик", "рыжий"),
                new Cat("Мурка", "белый"),
                new Cat("Снежок", "серый"),
                new Cat("Васька", "черный"),
                new Cat("Леопольд", "полосатый")
        };

        System.out.println("=== Созданы коты ===");
        for (Cat cat : cats) {
            cat.displaySatiety();
        }
        System.out.println();


        System.out.println("=== Коты идут к миске ===");
        cats[0].eat(bowl, 10);  // Барсик ест 10
        cats[1].eat(bowl, 15);  // Мурка ест 15
        cats[2].eat(bowl, 10);  // Снежок хочет 10, но должно не хватить
        cats[3].eat(bowl, 5);   // Васька ест 5
        cats[4].eat(bowl, 8);   // Леопольд пытается, но еды нет

        System.out.println();


        System.out.println("=== Добавляем еду ===");
        bowl.addFood(20);
        System.out.println();


        System.out.println("=== Голодные коты пробуют снова ===");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 10);
            }
        }

        System.out.println();


        System.out.println("=== Итоговая информация о сытости ===");
        for (Cat cat : cats) {
            cat.displaySatiety();
        }

        System.out.println();
        bowl.displayInfo();


        System.out.println();
        System.out.println("=== Проверка защиты от отрицательной еды ===");
        cats[0].eat(bowl, -5);


        System.out.println();
        System.out.println("=== Сытый кот не ест ===");
        cats[0].eat(bowl, 5);
    }
}
