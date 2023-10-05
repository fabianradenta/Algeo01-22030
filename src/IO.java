import java.util.*;
import java.io.*;

public class IO{
    public static Matrix readMatrixFromFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            // Determine the number of rows and columns in the file
            int rowcnt = 0;
            int colcnt = 0;

            while (fileScanner.hasNextLine()) {
                String[] temp = fileScanner.nextLine().split(" ");
                rowcnt++;
                colcnt = Math.max(colcnt, temp.length);
            }

            // Create a new matrix with the determined dimensions
            double[][] matrixData = new double[rowcnt][colcnt];

            // Reset the file scanner
            fileScanner.close();
            Scanner fileScanner2 = new Scanner(new File(fileName));

            // Read the matrix data from the file
            int i = 0;
            while (fileScanner2.hasNextLine()) {
                String[] temp = fileScanner2.nextLine().split(" ");
                for (int j = 0; j < temp.length; j++) {
                    matrixData[i][j] = Double.parseDouble(temp[j]);
                }
                i++;
            }

            // Create a new Matrix object and return it
            Matrix resMatr = new Matrix(rowcnt, colcnt);

            for (int p=0; p<rowcnt; p++){
                for (int q=0; q<colcnt; q++){
                    resMatr.data[p][q] = matrixData[p][q];
                }
            }

            return resMatr;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return null;
        }
    }

    public static void writeMatrixToFile(Matrix m, String fileName) {
        try (FileWriter writer = new FileWriter(new File(fileName))) {
            for (int i = 0; i < m.rows; i++) {
                for (int j = 0; j < m.columns; j++) {
                    writer.write(Double.toString(m.data[i][j]));
                    if (j < m.columns - 1) {
                        writer.write(" ");
                    }
                }
                writer.write("\n");
            }
            System.out.println("Matrix data has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
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

    public void pWriteMatrix(Matrix m){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan path file yang dituju\t: ");
        String fileName = scanner.nextLine();
        writeMatrixToFile(m, fileName);
        scanner.close();
    }
    
    public void pWriteString(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan path file yang dituju\t: ");
        String fileName = scanner.nextLine();
        writeStringToFile(msg, fileName);
        scanner.close();
    }

    
    
    // public static void main(String[] args) {    
    //     Matrix matr = new Matrix(3, 3);
    //     matr.readMatrix();
    //     writeMatrixToFile(matr, "tes.txt");
    //     readMatrixFromFile("../test/input/SPLAxB1.txt").displayMatrix();;
    // }
    
}