public class Interpolasi {
    public static double[] Polinom(Matrix matrix){
        Matrix newMatrix = new Matrix(matrix.getRows(),matrix.getColumns()+1);

        int i, j;
        for (i = 0; i < matrix.getRows() ; i++){
            for (j = 0; j < matrix.getColumns() ; j++){
                if (j==matrix.getColumns()) {
                    newMatrix.data[i][j]=matrix.data[i][1];
                } else {
                    newMatrix.data[i][j]=Math.pow(matrix.data[i][0],j);
                }
            }
        }
                // selesaiin pake OBE
        MetodeOBE.matriksElimGaussJordan(newMatrix);
        double[] solusi = MetodeOBE.solusiGaussJordan(newMatrix);
        return solusi;
    }



    public static String taksiranX (Matrix m, double x){
        double taksiran = 0;
        String res = "f(" + x + ") = ";

        int i;
        for (i = 0; i < m.getRows(); i++) {
            taksiran += m.data[i][m.getLastIdxCol()] * Math.pow(x, i);
        }

        res += String.format("%.4f", taksiran);
        return res;
    }
}
