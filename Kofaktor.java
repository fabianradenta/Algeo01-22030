public class Kofaktor {
    public static double determinanKofaktor(Matrix m) {
        double det = 0;

        // Basis
        if (m.getRows == 1 && m.getColumns == 1) {
            det = m.data[0][0];
        }
        // Rekurens
        else {
            int i = 0;
            for (int j = 0; j < m.getColumns; j++) {
                det += (m.data[i][j] * getKofaktor(m, i, j));

            }
        }
        return det;
    }


    public static double getKofaktor(Matrix m, int p, int q) {
        Matrix newMatrix = new Matrix(m.getColumns() - 1, m.getRows() - 1);    
        double det;

        int row;
        int col;
        for (row = 0; row < m.getRows(); row++){
            for (col = 0; col < m.getColumns(); col++){
                if (row != p && col != q){
                    newMatrix.data[row][col++] = m.data[row][col];
                    if (col == m.getColumns() - 1) {
                        col = 0;
                        row++;
                    }
                }
            }
        }  

        // rumus kofaktor = (-1)^(i+j), 
        // kalau jumlah index baris dan kolom genap, kofaktor positif
        if ((p + q) % 2 == 0) {
            det = determinanKofaktor(newMatrix);
        } 
        // kalau jumlah index baris dan kolom ganjil, kofaktor negatif
        else {
            det = -determinanKofaktor(newMatrix);
        }

        return det;
    }




    public static String cramer(Matrix m) {
        String res = new String();
        Matrix m1 = new Matrix(m.getRows(),m.getColumns());
        Matrix m2 = new Matrix(m.getRows(),m.getColumns());
        
        m.splitMatrix(m1, m2, m.getColumns() - 1);
        if (m1.isSquare()) {
            if (m1.isSingular()) { //matriks dengan determinan = 0
                res = "SPL memiliki banyak solusi atau tidak memiliki solusi. Silakan gunakan metode lain.\n";
            } else {
                double det = determinanKofaktor(m1);
                double[] valX = new double[m.row];
                Matrix temp = new Matrix(m.getRows(),m.getColumns());
                for (int i = 0; i < m1.getColumns(); i++) {
                    temp.copyMatrix(m1);
                    for (int j = 0; j < m1.getRows(); j++) { 
                        temp.data[j][i] = m2.data[j][0];
                    }
                    valX[i] = determinanKofaktor(temp) / det; // hitung nilai xi
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
    
    public static double setPrec(double num, int decPlaces) {
        BigDecimal bd = new BigDecimal(num).setScale(decPlaces, RoundingMode.HALF_UP);
        double res = bd.doubleValue();
        return res;
    }
}

