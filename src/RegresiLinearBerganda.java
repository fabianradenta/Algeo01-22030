import java.util.Scanner;

public class RegresiLinearBerganda {
    public static String driverRegresi(boolean inputKeyboard) {
        Matrix sampel = new Matrix(0, 0);
        if (inputKeyboard) { //masukan dari keyboard
            Matrix tempsampel = new Matrix(0, 0);
            tempsampel = inputRegresiKeyboard();
            sampel = tempsampel;
        } else { // masukkan dari file
            Matrix tempsampel = new Matrix(0, 0);
            IO.pReadMatrix(tempsampel);
            sampel = tempsampel;
        }
        double[] soal = new double[sampel.getColumns()-1];
        System.out.println("Masukkan nilai yang mau ditaksir :");
        MetodeOBE.bacaArray(soal);
        
        String fungsi = prosesRegresi(sampel, soal);
        return fungsi;
        // lanjutannya string p mau disimpan di file atau tidak
    }

    public static Matrix inputRegresiKeyboard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan jumlah pengubah (x) :");
        int jmlPengubah = sc.nextInt();
        while (jmlPengubah<1) {
            System.out.println("Masukkan tidak valid");
            System.out.println("Masukkan jumlah pengubah (x) :");
            jmlPengubah = sc.nextInt();
        }
        
        System.out.println("Masukkan jumlah sampel :");
        int jmlSampel = sc.nextInt();
        while (jmlSampel<1) {
            System.out.println("Masukkan tidak valid");
            System.out.println("Masukkan jumlah sampel :");
            jmlSampel = sc.nextInt();
        }
        Matrix sampel = new Matrix(jmlSampel, jmlPengubah+1);
        System.out.println("Masukkan sampel data :");
        sampel.readMatrix();
        return sampel;
    }

    public static String prosesRegresi(Matrix sampel, double[] soal){
    Matrix regresi = new Matrix(sampel.getColumns(),sampel.getColumns()+1);
    // Membuat matriks sampel baru dengan ukuran kolom ditambah 1 indeks
    // dan mengisi angka 1 pada indeks kolom 0 serta menyalin matriks sampel pada sisanya 
        Matrix smplAugment = new Matrix(sampel.getRows(), sampel.getColumns()+1);
        for (int i = 0; i < sampel.getRows(); i++) {
            smplAugment.data[i][0] = 1;
            for (int j = 0; j < sampel.getColumns(); j++) {
                smplAugment.data[i][j+1] = sampel.data[i][j];
            }
        } 
    // Algoritma Regresi linear berganda memanfaatkan matriks sampel baru
        for (int i = 0; i < regresi.getRows(); i++) {
            for (int j = 0; j < regresi.getColumns(); j++) {
                regresi.data[i][j] = jumlahHasilKali2Kolom(smplAugment, i, j);
            }
        }
        MetodeOBE.matriksElimGaussJordan(regresi);
        String fungsi = new String();
        double[] varBebas = MetodeOBE.solusiGaussJordan(regresi);
        double sum = regresi.data[0][regresi.getLastIdxCol()];
        fungsi = String.format("f(");
        for (int i = 0; i < soal.length; i++) {
            fungsi = fungsi + String.format("x%d",(i+1));
            if (i != soal.length-1) {
                fungsi = fungsi + String.format(", ");
            }
        }
        fungsi = fungsi + String.format(") = %.05f", sum );
        for (int index = 0; index < varBebas.length-1; index++) {
            sum = sum + soal[index]*varBebas[index+1];
            if (varBebas[index+1] > 0) {
                fungsi = fungsi + String.format(" + %.05f*x%d", varBebas[index+1], (index+1));
            } else if (varBebas[index+1] < 0) {
                fungsi = fungsi + String.format(" - %.05f*x%d", (-varBebas[index+1]), (index+1));
            }            
        }

        fungsi = fungsi + String.format("\n");
        fungsi = fungsi + String.format("f(");
        for (int i = 0; i < soal.length; i++) {
            fungsi = fungsi + String.format("%.05f", soal[i]);
            if (i != soal.length-1) {
                fungsi = fungsi + String.format(", ");
            }
        }
        fungsi = fungsi + String.format(") = %f\n", sum );
        return fungsi;
    }

    public static double jumlahHasilKali2Kolom (Matrix matriks, int kolom1, int kolom2){
    // I.S. Matriks, kolom1, dan kolom2 terdefinisi
    // F.S. Mengembalikan jumlah dari hasil kali data di kolom1 dan kolom2
        double sum = 0;
        for (int i = 0; i < matriks.getRows(); i++) {
            sum = sum + matriks.data[i][kolom1]*matriks.data[i][kolom2];
        }
        return sum;
    }
}
