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

    public static String polinomInterpolation(Matrix m){
        int i;
        double x;
        
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
        String strTaksiran = "Taksiran nilai f(" + x + ") pada titik tersebut adalah " + taksiran;
        scanElmt.close();
        return strTaksiran;
    }
}