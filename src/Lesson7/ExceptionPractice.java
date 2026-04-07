package Lesson7;



public class ExceptionPractice {

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        private int row;
        private int col;

        public MyArrayDataException(String message, int row, int col) {
            super(message + " в ячейке [" + row + "][" + col + "]");
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        //Тестовые массивы
        String[][] array = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] array2 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}, {"17"}};
        String[][] array3 = {{"1", "2", "3", "4", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] array4 = {{"1", "2", "string", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        try {
            //Выбрать массив из тестов
            int sum = arrayChecker(array4);
            System.out.println("Сумма: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int arrayChecker(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Неверный размер массива");
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " имеет длину " + array[i].length);
            }

            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "'" + array[i][j] + "' не число", i, j
                    );
                }
            }
        }

        return sum;
    }
}