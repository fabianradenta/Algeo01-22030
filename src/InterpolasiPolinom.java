import java.io.IOException;
import java.util.Scanner;

public class InterpolasiPolinomial {
public static Matrix matrixGenerator(Matrix m)
    {
        int i, j;
        double a, b, val;

        Matrix newMatrix = new Matrix(m.getRows(), m.getRows()+1);
        for(i=0; i<m.getRows(); i++){
            a = m.data[i][0];
            b = m.data[i][0];
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
        StringBuffer str = new StringBuffer();
        
        MetodeOBE.matriksElimGaussJordan(m);
        
        System.out.print("f(x) = ");
        str.append("f(x) = ");
        for(i=0; i<m.getRows(); i++){  
            if(i==0){
                System.out.print(m.data[i][m.getColumns()-1]);
            } else if (m.getElmt(i, m.getColumns()-1)>=0){
                System.out.print(" + " + m.data[i][m.getColumns()-1] + "x^" + i);
            } else {
                System.out.print(" - " + -1*m.data[i][m.getColumns()-1] + "x^" + i);
            }
        }
        System.out.println();
        
        System.out.println("Taksir nilai fungsi");
        System.out.print("Masukkan nilai x: ");
        
        Scanner scanElmt = new Scanner(System.in);
        x = scanElmt.nextDouble();
        hasil = 0;
        xPangkat=1;
        for(i=0; i<m.getRows(); i++){  
            hasil = hasil + m.data[i][m.getColumns()-1]*xPangkat;
            xPangkat = xPangkat*x;
        }
        return hasil;
    }
}