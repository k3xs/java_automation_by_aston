//Создать класс Park с внутренним классом,
// с помощью объектов которого можно хранить
// информацию об аттракционах, времени их работы и стоимости.
package Lesson4;

public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double price;

        public Attraction(String attractionName, String workingHours, double price) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void attractionInfo() {
            System.out.println("--------Аттракцион--------");
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println("--------------------------");
        }
    }

    public static void main(String[] args) {
        Park parkGorky = new Park("Парк Горького");

        Attraction shootingGallery = parkGorky.new Attraction("Тир", "10:00-20:00", 250);
        Attraction ferrisWheel = parkGorky.new Attraction("Колесо обозрения", "10:00-20:00", 300);
        Attraction autodrom = parkGorky.new Attraction("Автодром", "10:00-20:00", 400);

        shootingGallery.attractionInfo();
        ferrisWheel.attractionInfo();
        autodrom.attractionInfo();
    }

}
