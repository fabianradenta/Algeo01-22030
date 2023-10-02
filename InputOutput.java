import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;


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

    public static void writeMatrixToFile(Matrix m, String outputPath) {
        System.out.println();
        System.out.print("Apakah Anda ingin menyimpan hasil ke dalam sebuah file (Y/N)? ");
        Scanner in = new Scanner(System.in);
        String resp = (in.nextLine()).toUpperCase();
        switch (resp) {
            case "Y":
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
            case "N":
                System.out.println("Anda tidak melakukan penyimpanan hasil.");
                break;
            default:
                System.out.println("Input tidak dikenali. Hasil tidak disimpan.");
                break;
        }
    }

    public static Matrix createMatrix(boolean mustSquare) {
        Menu.displayMenuInput();
        int choice = -1;
        switch (choice){
            case 1:
                return inputMatrixKeyboard(mustSquare);
            case 2:
                return inputMatrixFile(mustSquare);
            default:
                System.out.println("Input tidak dikenali.");
                break;
        }
    }

    // Bikin matrix dr keyboard
    public static Matrix inputMatrixKeyboard(boolean mustSquare) {
        int rows, cols;

        while (true) {
        if (mustSquare) {
            System.out.println("Masukkan ukuran matriks");
            System.out.print("> ");
            rows = in.nextInt();
            cols = rows;
        } else {
            System.out.println("Masukkan jumlah baris dan kolom matriks");
            System.out.println("(Pisahkan dengan spasi)");
            System.out.print("> ");
            rows = in.nextInt();
            cols = in.nextInt();
        }
        if (rows > 0 && cols > 0) {
            break;
        } else {
            System.out.println("Masukan invalid. Jumlah baris dan kolom harus > 0");
        }

        Matrix matriks = new Matrix(rows, cols);
        

        System.out.println("Masukkan elemen matriks");
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColumns(); j++) {
                System.out.print("Elemen baris ke-" + (i + 1) + " kolom ke-" + (j + 1) + ": ");
                matriks.data[i][j] = in.nextDouble();
            }
        }

        return matriks;
    }

    // Bikin matrix dr File
    public static Matrix inputMatrixFile(boolean mustSquare) {
        String fileName;
        int[] rowsCols;

        while (true) {
        fileName = "../test/" + inputFileName();
        rowsCols = FileReadWrite.calcRowsCols(fileName);
        if (mustSquare && (rowsCols[0] != rowsCols[1])) {
            System.out.println("Matriks dalam file tidak berbentuk persegi");
        } else {
            break;
        }
        }
        matriks = FileReadWrite.readFile(fileName, rowsCols[0], rowsCols[1]);

        return matriks;
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

<<<<<<< Updated upstream:InputOutput.java
//hint : saya nambahin dalam bentuk 'komen' apa aja import yang kurang kalo masih bingung
=======
}
>>>>>>> Stashed changes:inputOutput.java
