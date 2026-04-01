package Lesson6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static void save(AppData data, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            String[] header = data.getHeader();
            writer.write(String.join(";", header));
            writer.newLine();


            int[][] matrix = data.getData();
            for (int[] row : matrix) {

                String[] rowStrings = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    rowStrings[i] = String.valueOf(row[i]);
                }
                writer.write(String.join(";", rowStrings));
                writer.newLine();
            }

            System.out.println("Данные успешно сохранены в файл: " + filename);

        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    public static AppData load(String filename) {
        List<String[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            String[] header = null;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(";");

                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }

                if (isFirstLine) {
                    header = parts;
                    isFirstLine = false;
                } else {
                    rows.add(parts);
                }
            }

            int[][] data = new int[rows.size()][];
            for (int i = 0; i < rows.size(); i++) {
                String[] row = rows.get(i);
                data[i] = new int[row.length];
                for (int j = 0; j < row.length; j++) {
                    try {
                        data[i][j] = Integer.parseInt(row[j]);
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка преобразования: " + row[j] + " не является числом");
                        data[i][j] = 0;
                    }
                }
            }

            System.out.println("Данные успешно загружены из файла: " + filename);
            return new AppData(header, data);

        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла: " + e.getMessage());
            return new AppData();
        }
    }


}
