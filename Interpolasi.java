public class Interpolasi {
    public static double[] Polinom(double[][]matrix){

        int n;
        n = matrix.length();
        double[][] newMatrix = double[n][n+1];

        int i, j;
        for (i = 0; i < n ; i++){
            for (j = 0; j < n ; j++){
                if (j==n) {
                    newMatrix[i][j]=matrix[i][1];
                } else {
                    newMatrix[i][j]=Math.pow(matrix[i][0],j);
                }
            }
        }

        // selesaiin pake OBE
    }



    public static String taksiranX (Matrix m, double x){
        double taksiran = 0;
        String res = "f(" + x + ") = ";

        int i;
        for (i = 0; i < m.row; i++) {
            taksiran += m.data[i][getLastIdxCol()] * Math.pow(x, i);
        }

        res += String.format("%.4f", taksiran);
        return res;
    }
}
