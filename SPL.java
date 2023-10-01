public class SPL{
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

    public static void main(String[] args) {
        
        Matrix matr = new Matrix(4, 5);
        matr.readMatrix();
        System.out.println();
        SPLMatrix(matr).displayMatrix();
        // System.out.println(SPLMatrix(matr));
    }
}

