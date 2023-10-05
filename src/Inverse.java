public class Inverse{
    public static String displayInverse(Matrix x){
        String res = new String();
        for (int i = 0; i < x.getRows(); i++) {
            double ans = Kofaktor.setPrec((0.000000 + x.data[i][0]), 6);
            res += ("x_" + (i + 1) + " = " + String.format("%.2f", ans) + "\n");
        }
        return res;
    }

    public static Matrix SPLMatrix(Matrix m){
        Matrix A = new Matrix(m.getRows(), m.getColumns()-1);
        Matrix b = new Matrix(m.getRows(),1);
        Matrix x = new Matrix(m.getRows(),1);


        for (int i=0; i<A.getRows(); i++){
            for (int j=0; j<A.getColumns(); j++){
                A.data[i][j] = m.data[i][j];
            }
        }

        for (int i=0; i<m.getRows();i++){
            b.data[i][0] = m.data[i][m.getLastIdxCol()];
        }

        Matrix aInverse = new Matrix(A.getRows(), A.getColumns());
        aInverse = A.inverseWithAdjoint();
        if (aInverse != null){
            x = aInverse.multiplyMatrix(b);
            return x;
        }
        else {
            // bisa jadi ga ada solusi, bisa jadi solusi parametrik
            // ini belum tau algoritmanya gimana
            return null;
        }
    }
}