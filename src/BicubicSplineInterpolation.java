import java.util.Scanner;

public class BicubicSplineInterpolation {
    public static String driverBicubic(boolean inputKeyboard) {
        // ini masih input-an keyboard, untuk yang file belum
        Scanner sc = new Scanner(System.in);
        Matrix mSoal = new Matrix(4,4);
        String fungsi = new String();
        if (inputKeyboard) {
            System.out.println("Masukkan konfigurasi nilai fungsi dan turunan berarah disekitarnya :");
            mSoal.readMatrix();
        } else {
            Matrix tempmSoal = new Matrix(4,4);
            IO.pReadMatrix(tempmSoal);
            mSoal = tempmSoal;
        }
        System.out.println("Masukkan nilai f(x,y) yang mau ditaksir :");
        double xSoal = sc.nextDouble();
        double ySoal = sc.nextDouble();

        Matrix mSoalBicubic = new Matrix(4*mSoal.getRows(), 1);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mSoalBicubic.data[i*4 + j][0] = mSoal.data[i][j]; 
            }
        }
        Matrix mBicubic = matrixBicubicSplineInterpolation();
        //System.out.println("hasil akhir");
        Matrix inversBicubic = MetodeOBE.balikanOBE(mBicubic);
        inversBicubic.pMultiplyMatrix(mSoalBicubic);
        double hasil = solusiBicubic(inversBicubic, xSoal, ySoal);
        fungsi = String.format("f(%f,%f) = %f", xSoal,ySoal,hasil );
        return fungsi;

    }


    public static Matrix matrixBicubicSplineInterpolation(){
        Matrix mBicubic = new Matrix(16,16);

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                barisBicubic(mBicubic, x, y);
            }
        }

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                barisBicubicTurunanX(mBicubic, x, y);
            }
        }

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                barisBicubicTurunanY(mBicubic, x, y);
            }
        }

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 2; x++) {
                barisBicubicTurunanXY(mBicubic, x, y);
            }
        }
        return mBicubic;
    }

    public static void barisBicubic(Matrix matriks, int x, int y){
    // I.S. Matriks, nilai x, nilai y terdefinisi
    // F.S. Membuat baris yang berisi sigma aij * x^i * y^j 
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                matriks.data[x+y*2][i + j*4] = Math.pow(x, i)*Math.pow(y,j); 
            }
        }
    }

    public static void barisBicubicTurunanX(Matrix matriks, int x, int y){
    // I.S. Matriks, nilai x, nilai y terdefinisi
    // F.S. Membuat baris yang berisi turunan x dari sigma aij * x^i * y^j 
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (i != 0) {
                    matriks.data[4+x+y*2][i + j*4] = i*Math.pow(x, i-1)*Math.pow(y,j);
                } else {
                    matriks.data[4+x+y*2][i + j*4] = 0;
                } 
            }
        }
    }

    public static void barisBicubicTurunanY(Matrix matriks, int x, int y){
    // I.S. Matriks, nilai x, nilai y terdefinisi
    // F.S. Membuat baris yang berisi turunan y dari sigma aij * x^i * y^j 
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (j != 0) {
                    matriks.data[8+x+y*2][i + j*4] = j*Math.pow(x, i)*Math.pow(y,j-1);
                } else {
                    matriks.data[8+x+y*2][i + j*4] = 0;
                } 
            }
        }    
    }
    
    public static void barisBicubicTurunanXY(Matrix matriks, int x, int y){
    // I.S. Matriks, nilai x, nilai y terdefinisi
    // F.S. Membuat baris yang berisi turunan xy dari sigma aij * x^i * y^j 
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (i != 0 && j != 0) {
                    matriks.data[12+x+y*2][i + j*4] = i*j*Math.pow(x, i-1)*Math.pow(y,j-1);
                } else {
                    matriks.data[12+x+y*2][i + j*4] = 0;
                } 
            }
        }
    }

    public static double solusiBicubic(Matrix matriks, double x, double y){
    // I.S. Matriks, nilai x, nilai y terdefinisi
    // F.S. Mengembalikan nilai interpolasi bicubic spline
        double sum = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                double koef = matriks.data[i+j*4][0];
                sum = sum +  koef*Math.pow(x, i)*Math.pow(y,j); 
            }
        }
        return sum;
    }
}
