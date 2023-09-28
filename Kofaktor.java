public class Kofaktor {
    public static double determinanKofaktor(Matrix m) {
        double det = 0;

        // Basis
        if (getRows(m) == 1 && getCols(m) == 1) {
            det = m.data[0][0];
        }
        // Rekurens
        else {
            int i = 0;
            for (int j = 0; j < getCols(m); j++) {
                det += (m.data[i][j] * getKofaktor(m, i, j));

            }
        }
        return det;
    }


    public static double getKofaktor(Matrix m, int p, int q) {
        Matrix newMatrix = new Matrix(m.cols - 1, m.rows - 1);    
        double det;

        int row;
        int col;
        for (row = 0; row < getRows(m); row++){
            for (col = 0; col < getCols(m); col++){
                if (row != p && col != q){
                    newMatrix.data[i][j++] = m.data[row][col];
                    if (j == getCols(m) - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }  

        // rumus kofaktor = (-1)^(i+j), 
        // kalau jumlah index baris dan kolom genap, kofaktor positif
        if ((p + q) % 2 == 0) {
            det = determinanKofaktor(tempMat);
        } 
        // kalau jumlah index baris dan kolom ganjil, kofaktor negatif
        else {
            det = -determinanKofaktor(tempMat);
        }

        return det;
    }




    public static String cramer(Matrix m) {
        String res = new String();
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        
        m.splitMatrix(m1, m2, m.col - 1);
        if (m1.isSquare()) {
            if (m1.isSingular()) { //matriks dengan determinan = 0
                res = "SPL memiliki banyak solusi atau tidak memiliki solusi. Silakan gunakan metode lain.\n";
            } else {
                double det = determinanKofaktor(m1);
                double[] valX = new double[m.row];
                Matrix temp = new Matrix();
                for (int i = 0; i < m1.col; i++) {
                    temp.copyMatrix(m1);
                    for (int j = 0; j < m1.row; j++) { 
                        temp.mat[j][i] = m2.mat[j][0];
                    }
                    valX[i] = Determinant.determinanKofaktor(temp) / det; // hitung nilai xi
                }
                for (int i = 0; i < m.row; i++) {
                    double ans = setPrec((0.000000 + valX[i]), 6);
                    res += ("x_" + (i + 1) + " = " + String.format("%.2f", ans) + "\n");
                }
            }
        } else {
            res = "SPL tidak bisa diselesaikan dengan kaidah Cramer. Silakan gunakan metode lain.\n";
        }
        return res;
    }

}

