import java.io.IOException;
import java.util.Scanner;

public class InterpolasiPolinom {

    public static Matrix matrixGenerator(Matrix m){
        int i, j;
        double a, b, val;

        Matrix newMatrix = new Matrix(m.getRows(), m.getRows()+1);
        for(i=0; i<m.getRows(); i++){
            a = m.data[i][0];
            b = m.data[i][1];
            val = 1;
        
            for(j=0; j<newMatrix.getColumns(); j++){
                if(j==newMatrix.getColumns()-1){
                    newMatrix.data[i][j]=b;
                } else {
                    newMatrix.data[i][j]=val;
                    val = val*a;
                }
            }
        }
        return newMatrix;
    }

    public static double polinomInterpolation(Matrix m){
        int i;
        double x;
        double hasil, xPangkat;
        final StringBuffer str = new StringBuffer();
        
        MetodeOBE.matriksElimGaussJordan(m);
        
        String res = "f(x) = ";
        for(i=0; i<m.getRows(); i++){  
            String negative = String.format("%.4f", -m.data[i][m.getColumns() - 1]);
            String positive = String.format("%.4f", m.data[i][m.getColumns() - 1]);
            if (i == 0) {
                    res += (m.data[i][m.getColumns() - 1] <= 0 ? " - " + negative : " + " + positive);
                } else if (i == 1) {
                    res += (m.data[i][m.getColumns() - 1] <= 0 ? " - " + negative : " + " + positive) + "x";
                } else if (i == m.getRows() - 1) {
                    res += (m.data[i][m.getColumns() - 1] <= 0 ? " - " + negative : " " + positive) + "x^" + i;
                } else {
                    res += (m.data[i][m.getColumns() - 1] <= 0 ? " - " + negative : " + " + positive) + "x^" + i;
                }
        }
        System.out.println(res);
        m.displayMatrix();
        System.out.println();
        
        System.out.println("Taksir nilai fungsi");
        System.out.print("Masukkan nilai x: ");
        
        Scanner scanElmt = new Scanner(System.in);
        x = scanElmt.nextDouble();

        double taksiran = 0;
        for (i = 0; i < m.getRows(); i++) {
            taksiran += m.data[i][m.getColumns() - 1] * Math.pow(x, i);
        }
        
        return taksiran;
    }

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Masukkan jumlah sampel: ");
    //     int n = scanner.nextInt();

    //     // Membaca sampel dari keyboard
    //     Matrix sampel = inputSampelKeyboard(n);

    //     // Menghasilkan matriks interpolasi
    //     Matrix interpolasiMatrix = matrixGenerator(sampel);

    //     // Menghitung polinom interpolasi
    //     double hasilInterpolasi = polinomInterpolation(interpolasiMatrix);

    //     System.out.println("Hasil interpolasi: " + hasilInterpolasi);
    // }

    // public static Matrix inputSampelKeyboard(int n) {
    //     Scanner scanner = new Scanner(System.in);
    //     Matrix data = new Matrix(n,2); // Mengasumsikan setiap sampel terdiri dari dua nilai (x dan y)

    //     System.out.println("Masukkan nilai x dan y untuk setiap sampel:");
    //     for (int i = 0; i < n; i++) {
    //         System.out.print("Sampel " + (i + 1) + ": ");
    //         data.data[i][0] = scanner.nextDouble(); // Input nilai x
    //         data.data[i][1] = scanner.nextDouble(); // Input nilai y
    //     }

    //     return data;
    // }
}