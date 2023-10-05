import java.util.*;
import java.io.*;

public class IO{
    public static void pReadMatrixFromFile(Matrix m){
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        if (readMatrixFromFile(fileName) != null){
            m = readMatrixFromFile(fileName);
        }
        else {
            m = null;
        }
    }

    public static Matrix readMatrixFromFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            int rowcnt = 0;
            int colcnt = 0;
            Matrix matrixData = new Matrix(0, 0);

            while (fileScanner.hasNextLine()) {
                String[] temp = fileScanner.nextLine().split(" ");
                rowcnt++;
                colcnt = Math.max(colcnt, temp.length);
            }

            matrixData.rows = rowcnt;
            matrixData.columns = colcnt;

            fileScanner.close();

            try (Scanner matrixScanner = new Scanner(new File(fileName))) {
                int i = 0;
                while (matrixScanner.hasNextLine()) {
                    String[] temp = matrixScanner.nextLine().split(" ");
                    for (int j = 0; j < temp.length; j++) {
                        matrixData.data[i][j] = Double.parseDouble(temp[j]);
                    }
                    i++;
                }
            }

            return matrixData;
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + "tidak ditemukan");
            return null;
        }
    }
}