package Lesson5;

public class Bowl {
    private int foodAmount;  // количество еды в миске

    public Bowl(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount);
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды!");
        }
    }

    public boolean takeFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя съесть отрицательное количество еды!");
            return false;
        }

        if (foodAmount >= amount) {
            foodAmount -= amount;
            System.out.println("Из миски взято " + amount + " еды. Осталось: " + foodAmount);
            return true;
        } else {
            System.out.println("В миске недостаточно еды! Нужно: " + amount + ", есть: " + foodAmount);
            return false;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void displayInfo() {
        System.out.println("В миске: " + foodAmount + " еды");
    }
}
