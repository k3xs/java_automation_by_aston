package Lesson10;

// Fruit.java
import java.util.ArrayList;
import java.util.List;

abstract class Fruit {
    abstract float getWeight();
}

class Apple extends Fruit {
    @Override
    float getWeight() {
        return 1.0f;
    }
}

class Orange extends Fruit {
    @Override
    float getWeight() {
        return 1.5f;
    }
}

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<? extends Fruit> other) {
        return Math.abs(this.getWeight() - other.getWeight()) < 0.0001f;
    }

    public void transferTo(Box<T> other) {
        other.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public int getCount() {
        return fruits.size();
    }
}