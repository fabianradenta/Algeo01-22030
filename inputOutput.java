import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

public class InputOutput{
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

    public static void outputFromKeyboard(double[][] matrix, int row, int col) {
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
        String resp = (in.nextLine()).toUpperCase();
        switch (resp) {
            case "Y":
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
                    for (int i = 0; i < getRows(); i++) {
                        for (int j = 0; j < getColumns(); j++) {
                            String formattedValue = String.format("%.4f", m.data[i][j]);
                            writer.write(formattedValue);
                            if (j != getColumns() - 1) {
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
}