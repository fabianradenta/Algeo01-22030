import java.util.Scanner;

public class RegresiLinearBerganda {
    public static void regresiLinearBerganda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan jumlah pengubah (x) :");
        int jmlPengubah = sc.nextInt();
        System.out.println("Masukkan jumlah sampel :");
        int jmlSampel = sc.nextInt();
        Matrix sampel = new Matrix(jmlSampel, jmlPengubah+1);
        Matrix regresi = new Matrix(jmlPengubah+1, jmlPengubah+2);
        double[] soal = new double[jmlPengubah];
        
        System.out.println("Masukkan sampel data :");
        MetodeOBE.readMatrix(sampel);
        MetodeOBE.cetakMatriks(sampel);
        System.out.println("Masukkan nilai yang mau ditaksir :");
        bacaArray(soal);

        Matrix smplAugment = new Matrix(jmlSampel, jmlPengubah+2);
        for (int i = 0; i < jmlSampel; i++) {
            smplAugment.data[i][0] = 1;
            for (int j = 0; j < jmlPengubah+1; j++) {
                smplAugment.data[i][j+1] = sampel.data[i][j];
            }
        } 
        for (int i = 0; i < regresi.getRows(); i++) {
            for (int j = 0; j < regresi.getColums(); j++) {
                regresi.data[i][j] = jumlahHasilKali2Kolom(smplAugment, i, j);
            }
        }
        MetodeOBE.matriksElimGaussJordan(regresi);
        double[] varBebas = MetodeOBE.solusiGaussJordan(regresi);
        double sum = regresi.data[0][regresi.getLastIdxCol()];
        for (int index = 0; index < varBebas.length-1; index++) {
            sum = sum + soal[index]*varBebas[index+1];
        }        
    }

    public static double jumlahHasilKali2Kolom (Matrix matriks, int kolom1, int kolom2){
        double sum = 0;
        for (int i = 0; i < matriks.getRows(); i++) {
            sum = sum + matriks.data[i][kolom1]*matriks.data[i][kolom2];
        }
        return sum;
    }
}
