// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
import java.util.*;
import java.io.*;


public class InputOutput{
    private static Scanner in = new Scanner(System.in);
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = 3;
        int n = 3;
        Matrix matrix = new Matrix(m, n);
        inputFromKeyboard(scan, matrix, m, n);

        readMatrixFromFile();
    }



    public static void inputFromKeyboard(Scanner scan, Matrix matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix.data[i][j] = scan.nextDouble();
            }
        }
    }

    public static void outputFromKeyboard(Matrix matrix, int row, int col) {
        int i;
        int j;

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.printf("%.3f ", matrix.data[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrix readMatrixFromFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama file: ");
        String fileName = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File("../test/input/" + fileName))) {
            int rowcnt = 0;
            int colcnt = 0;

            while (fileScanner.hasNextLine()) {
                String[] temp = fileScanner.nextLine().split(" ");
                rowcnt++;
                colcnt = Math.max(colcnt, temp.length);
            }

            Matrix ret = new Matrix(rowcnt, colcnt);

            fileScanner.close();

            try (Scanner matrixScanner = new Scanner(new File("../test/input/" + fileName))) {
                int i = 0;
                while (matrixScanner.hasNextLine()) {
                    String[] temp = matrixScanner.nextLine().split(" ");
                    for (int j = 0; j < temp.length; j++) {
                        ret.data[i][j] = Double.parseDouble(temp[j]);
                    }
                    i++;
                }
            }

            return ret;
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");
            return null;
        }
    }

    public static void writeMatrixToFile(Matrix m, String outputPath,int resp) {
        switch (resp) {
            case 1:
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
                    for (int i = 0; i < m.getRows(); i++) {
                        for (int j = 0; j < m.getColumns(); j++) {
                            String formattedValue = String.format("%.4f", m.data[i][j]);
                            writer.write(formattedValue);
                            if (j != m.getColumns() - 1) {
                                writer.write(" ");
                            }
                        }
                        writer.newLine();
                    }
                    System.out.println("Hasil berhasil disimpan di: " + outputPath);
                } catch (IOException e) {
                    System.out.println("Gagal menyimpan file: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("Anda tidak melakukan penyimpanan hasil.");
                break;
            default:
                System.out.println("Input tidak dikenali. Hasil tidak disimpan.");
                break;
        }
    }

    // Bikin matrix dr File
    public static Matrix inputMatrixFile(boolean mustSquare) {
        String fileName;
        int[] rowsCols;

        while (true) {
        fileName = "../test/" + inputFileName();
        rowsCols = calcRowsCols(fileName);
        if (mustSquare && (rowsCols[0] != rowsCols[1])) {
            System.out.println("Matriks dalam file tidak berbentuk persegi");
        } else {
            break;
        }
        }
        Matrix  matriks = new Matrix(0, 0);
        matriks = readFile(fileName, rowsCols[0], rowsCols[1]);

        return matriks;
    }

    public static Matrix readFile(String fileName, int rows, int cols) {
        // Membaca file input dan mengembalikan matriks bacaan
        Matrix mat = new Matrix(rows, cols);
    
        System.out.println("Mencoba membaca file: " + fileName);
    
        FileReader fr = null;
        try {
          fr = new FileReader(fileName);
        } catch (FileNotFoundException fe) {
          System.out.println("File tidak ditemukan");
        }
        Scanner rowScanner2 = new Scanner(fr);
    
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            double input = rowScanner2.nextDouble();
            mat.data[i][j] = input;
          }
        }
        rowScanner2.close();
        return mat;
      }

    public static String inputFileName() {
        String fileName;
        FileReader fr = null;

        System.out.println("Masukkan nama file");
        System.out.print("> ");
        fileName = in.next();
        try {
            fr = new FileReader("../test/" + fileName);
        } catch (FileNotFoundException fe) {
            System.out.println("File tidak ditemukan.");
            fileName = inputFileName();
        }

        return fileName;
    }

    public static int[] calcRowsCols(String fileName) {
        // Menghitung jumlah baris dan kolom dari matriks input file
        FileReader fr = null;
        try {
          fr = new FileReader(fileName);
        } catch (FileNotFoundException fe) {
          System.out.println("File tidak ditemukan");
        }
    
        int rows = 0, cols = 0;
        String row = "";
        Scanner rowScanner = new Scanner(fr);
        while (rowScanner.hasNextLine()) {
          rows++;
          row = rowScanner.nextLine();
        }
        Scanner colScanner = new Scanner(row);
        while (colScanner.hasNextDouble()) {
          cols++;
          colScanner.nextDouble();
        }
        rowScanner.close();
        colScanner.close();
    
        int[] rowsCols = new int[2];
        rowsCols[0] = rows;
        rowsCols[1] = cols;
    
        return rowsCols;
      }    

    public static void writeStringToFile(String msg, String filePath){
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(msg);
            // Close the FileWriter to ensure that the data is flushed and the file is saved
            writer.close();
            System.out.println("String berhasil ditulis ke file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
