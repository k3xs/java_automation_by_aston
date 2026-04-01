package Lesson6;

public class AppCsv {
    public static void main(String[] args) {
        String filename = "data.csv";

        // Ввод данных
        System.out.println("===== Создание данных =====");

        String[] header = {"Value 1", "Value 2", "Value 3"};

        int[][] data = {
                {100, 200, 123},
                {300, 400, 500},
                {150, 250, 350},
                {10, 20, 30}
        };

        AppData appData = new AppData(header, data);

        System.out.println("Исходные данные:");
        appData.printInfo();

        // Сохранение в CSV файл
        System.out.println("\n----- Сохранение -----");
        FileHandler.save(appData, filename);

        // Загрузка данных из файла
        System.out.println("\n===== Загрузка данных из файла =====");

        AppData loadedData = FileHandler.load(filename);

        System.out.println("\nЗагруженные данные:");
        loadedData.printInfo();

        // Перезапись файла
        System.out.println("\n=== Демонстрация перезаписи файла ===");

        String[] newHeader = {"ID", "Name", "Score"};
        int[][] newData = {
                {1, 100, 95},
                {2, 200, 85},
                {3, 300, 90}
        };

        AppData newAppData = new AppData(newHeader, newData);

        FileHandler.save(newAppData, filename);

        AppData reloadedData = FileHandler.load(filename);
        System.out.println("\nДанные после перезаписи:");
        reloadedData.printInfo();
    }
}
