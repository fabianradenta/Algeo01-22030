import java.util.Scanner;

public class RegresiLinearBerganda {
    public static void regresiLinearBerganda() {
    // I.S. Sembarang
    // F.S. mencetak hasil regresi linear berganda
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan jumlah pengubah (x) :");
        int jmlPengubah = sc.nextInt();
        System.out.println("Masukkan jumlah sampel :");
        int jmlSampel = sc.nextInt();
        Matrix sampel = new Matrix(jmlSampel, jmlPengubah+1);
        Matrix regresi = new Matrix(jmlPengubah+1, jmlPengubah+2);
        double[] soal = new double[jmlPengubah];
        
        System.out.println("Masukkan sampel data :");
        sampel.readMatrix();
        // sampel.displayMatrix();
        System.out.println("Masukkan nilai yang mau ditaksir :");
        MetodeOBE.bacaArray(soal);

    // Membuat matriks sampel baru dengan ukuran kolom ditambah 1 indeks
    // dan mengisi angka 1 pada indeks kolom 0 serta menyalin matriks sampel pada sisanya 
        Matrix smplAugment = new Matrix(jmlSampel, jmlPengubah+2);
        for (int i = 0; i < jmlSampel; i++) {
            smplAugment.data[i][0] = 1;
            for (int j = 0; j < jmlPengubah+1; j++) {
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
        double[] varBebas = MetodeOBE.solusiGaussJordan(regresi);
        double sum = regresi.data[0][regresi.getLastIdxCol()];
        for (int index = 0; index < varBebas.length-1; index++) {
            sum = sum + soal[index]*varBebas[index+1];
        }       
        System.out.println(sum); 
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
