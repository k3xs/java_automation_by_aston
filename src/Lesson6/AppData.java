package Lesson6;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData (String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public AppData() {
        this.header = new String[0];
        this.data = new int[0][0];
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void printInfo() {
        System.out.println("===== header =====");
        for (String h : header) {
            System.out.print(h + " | ");
        }

        System.out.println();
        System.out.println("===== data =====");
        for (int[] row : data) {
            for (int value : row) {
                System.out.print(value + " | ");
            }
            System.out.println();
        }
    }
}
