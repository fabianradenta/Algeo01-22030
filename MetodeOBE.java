import java.util.Scanner;

public class MetodeOBE {

    public static void tukarBaris(Matrix matriks, int baris1, int baris2){
        for (int i = 0; i < matriks.getColums(); i++) {
            double temp = matriks.data[baris1][i];
            matriks.data[baris1][i] = matriks.data[baris2][i];
            matriks.data[baris2][i] = temp;
        }
    }

    public static void kaliKonstan(Matrix matriks, double koef, int baris){
        for (int i = baris; i < matriks.getColums(); i++) {
            matriks.data[baris][i] = matriks.data[baris][i]/koef;    
        }
    }

    public static void operasiBaris(Matrix matriks, double koef, int baris1, int baris2){
        for (int i = 0; i < matriks.getColums(); i++) {
            matriks.data[baris2][i] = matriks.data[baris2][i]-koef*matriks.data[baris1][i];
        } 
    }

    public static void matriksElimGauss(Matrix matriks) {
        int idx1UtamaBaris=0;
        // int idx1UtamaKolom=0;
        
        for (int i = 0; i < matriks.getColums(); i++) {
            
            if (idx1UtamaBaris == matriks.getRows()) {
                break;
            }

            int j = idx1UtamaBaris;
            while (j<matriks.getRows() && matriks.data[j][i] == 0) {
                j++;
            }
            if (matriks.data[idx1UtamaBaris][i] == 0 && j != matriks.getRows()) {
                tukarBaris(matriks, idx1UtamaBaris, j);
            }
            if (matriks.data[idx1UtamaBaris][i] !=1 && matriks.data[idx1UtamaBaris][i] != 0) {
                double koef = matriks.data[idx1UtamaBaris][i];
                kaliKonstan(matriks, koef, idx1UtamaBaris);
            } 
            for (int k = idx1UtamaBaris+1; k < matriks.getRows(); k++) {
                double koef = matriks.data[k][i];
                operasiBaris(matriks, koef, idx1UtamaBaris, k);
            }    
            if (j != matriks.getRows()) {
                idx1UtamaBaris++;
            }
        }
    }

    public static double[] subtitusiMundur(Matrix matriks){
        double[] solusi = new double[matriks.getRows()];
        for (int i = matriks.getRows()-1; i >= 0; i--) {
            solusi[i] = matriks.data[i][matriks.getColums()-1];
            for (int j = i+1; j < matriks.getColums()-1; j++) {
                solusi[i]=solusi[i] - matriks.data[i][j]*solusi[j];
            }
        }
        return solusi;
    }

    public static void matriksElimGaussJordan(Matrix matriks){
        int idx1UtamaBaris = matriks.getRows() - 1;
        int idx1UtamaKolom = matriks.getColums() - 1;
        matriksElimGauss(matriks);
        for (int i = idx1UtamaBaris; i > -1; i--) {
            int j = 0;
            while (matriks.data[i][j] == 0 && j != idx1UtamaKolom) {
                j++;
            }
            if (j != idx1UtamaKolom) {
                idx1UtamaKolom = j;
            }
            for (int k = idx1UtamaBaris-1; k > -1; k--) {
                double koef = matriks.data[k][idx1UtamaKolom];
                operasiBaris(matriks, koef, idx1UtamaBaris, k);
            }
            idx1UtamaBaris--;
        }
    }

    public static double[] solusiGaussJordan(Matrix matriks){
        double[] solusi = new double[matriks.getRows()];
        for (int i = 0; i < matriks.getRows(); i++) {
            solusi[i] = matriks.data[i][matriks.getColums()-1];
        }
        return solusi;
    }

    public static double determinanOBE(Matrix matriks){
        int jmlTukar=0;
        int idx1UtamaBaris=0;
        // int idx1UtamaKolom=0;
        
        for (int i = 0; i < matriks.getColums(); i++) {
            if (idx1UtamaBaris == matriks.getRows()) {
                break;
            }
            int j = idx1UtamaBaris;
            while (j<matriks.getRows() && matriks.data[j][i] == 0) {
                j++;
            }

            if (matriks.data[idx1UtamaBaris][i] == 0 && j != matriks.getRows()) {
                tukarBaris(matriks, idx1UtamaBaris, j);
                jmlTukar++;
            }

            for (int k = idx1UtamaBaris+1; k < matriks.getRows(); k++) {
                double koef = matriks.data[k][i]/matriks.data[idx1UtamaBaris][i];
                operasiBaris(matriks, koef, idx1UtamaBaris, k);
            }
                
            if (j != matriks.getRows()) {
                idx1UtamaBaris++;
            }
        }

        double det = 1;
        for (int i = 0; i < matriks.getRows() ; i++) {
            det = det*matriks.data[i][i];
        }
        det = det*Math.pow((-1), jmlTukar);
        return det;
    }

    public static Matrix balikanOBE(Matrix matriks){
        Matrix matriksbalikan = new Matrix(matriks.getRows(), 2*matriks.getColums());
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColums() ; j++) {
                matriksbalikan.data[i][j]=matriks.data[i][j];
            }
            for (int k = matriks.getColums(); k < 2*matriks.getColums(); k++) {
                if (i + matriks.getColums() == k){
                    matriksbalikan.data[i][k] = 1;
                } else {
                    matriksbalikan.data[i][k] = 0;
                }    
            }
        }
        matriksElimGaussJordan(matriksbalikan);
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColums(); j++) {
                matriks.data[i][j]= matriksbalikan.data[i][j+matriks.getColums()];
            }
        }
        return matriks;
    }
    
    public static void gaussSPL(Matrix matriks){
        double det;
        double[] solusi;
        Matrix cekmatriks = new Matrix(matriks.getRows(), matriks.getColums()-1);
        for (int index = 0; index < matriks.getRows(); index++) {
            for (int i = 0; i < matriks.getColums()-1; i++) {
              cekmatriks.data[index][i] = matriks.data[index][i]; 
            }
        }
        det = determinanOBE(cekmatriks);
        if (matriks.getRows() == matriks.getColums()-1 && det != 0) {
            matriksElimGauss(matriks);
            solusi = subtitusiMundur(matriks);
            cetakSolusi(solusi);
        } else {
            System.out.println("TIDAK KONSISTEN");
            boolean adaSolusi = true;
            matriksElimGaussJordan(matriks);
            int i=matriks.getRows()-1;
            while (i >-1 && !cekAda1Utama(matriks, i) && adaSolusi) {
                if (matriks.data[i][matriks.getColums()-1] != 0) {
                    adaSolusi = false;
                } else

                i--;
            }
            System.out.println(i);
            if (adaSolusi) {
                parametrik(matriks);
            } else {
                System.out.println("Tidak Memiliki Solusi");
            }
        }
    }

    public static void gaussJordanSPL(Matrix matriks){
        double det;
        double[] solusi;
        Matrix cekmatriks = new Matrix(matriks.getRows(), matriks.getColums()-1);
        for (int index = 0; index < matriks.getRows(); index++) {
            for (int i = 0; i < matriks.getColums()-1; i++) {
              cekmatriks.data[index][i] = matriks.data[index][i]; 
            }
        }
        det = determinanOBE(cekmatriks);
        if (matriks.getRows() == matriks.getColums() && det != 0) {
            matriksElimGaussJordan(matriks);
            cetakMatriks(matriks);
            solusi = solusiGaussJordan(matriks);
            cetakSolusi(solusi);
        } else {
            System.out.println("TIDAK KONSISTEN");
            boolean adaSolusi = true;
            matriksElimGaussJordan(matriks);
            int i=matriks.getRows()-1;
            while (i >-1 && !cekAda1Utama(matriks, i) && adaSolusi) {
                if (matriks.data[i][matriks.getColums()-1] != 0) {
                    adaSolusi = false;
                } else

                i--;
            }
            System.out.println(i);
            if (adaSolusi) {
                parametrik(matriks);
            } else {
                System.out.println("Tidak Memiliki Solusi");
            }
        }

    }

    public static void cetakSolusi(double[] solusi){
        for (int i = 0; i < solusi.length; i++) {
            System.out.print("x" + (i + 1) + " = ");
            System.out.print(solusi[i]);
            if (i != solusi.length-1) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

    public static int satupertamakolom(Matrix matriks, int i){
        int j = 0;
        while (j<matriks.getColums()-1 && matriks.data[i][j]==0 ) {
            j++;
        }
        return j;
    }

    public static boolean cekAda1Utama(Matrix matriks, int i){
        int j = 0;
        while (j<matriks.getColums()-1 && matriks.data[i][j]==0 ) {
            j++;
        }
        if (j != matriks.getColums()-1) {
            return true;
        } else {
            return false;
        }
    }

    public static void parametrik(Matrix matriks){
        double[] idksolusi = new double[matriks.getColums()-1];
        for (int i = 0; i < matriks.getRows(); i++) {
            if (cekAda1Utama(matriks, i)){
                int j = satupertamakolom(matriks, i);
                idksolusi[j] = 1;
            }
        }

        for (int i = 0; i < idksolusi.length; i++) {
            if (idksolusi[i] == 0) {
                System.out.println("x"+(i +1)+" = t"+ (i+1));
            }
        }
        for (int i = 0; i < matriks.getRows(); i++) {
            if (cekAda1Utama(matriks, i)){
            System.out.print("x"+(satupertamakolom(matriks, i) +1)+" = "+ matriks.data[i][matriks.getColums()-1] + " ");
                for (int j = satupertamakolom(matriks, i); j < matriks.getColums() - 1; j++) {
                    //int k = 0;
                    if (idksolusi[j] != 1) {
                        if (matriks.data[i][j] > 0) {
                            System.out.print("- " +matriks.data[i][j]+"*t" + (j+1) +" ");
                        } else if (matriks.data[i][j] < 0){
                            System.out.print("+ " +(-matriks.data[i][j])+"*t" + (j+1) +" ");
                        }                        
                    }
                }
                System.out.println();
            }
        }
    }

    public static void readMatrix(Matrix matriks){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColums(); j++) {
                matriks.data[i][j] = scanner.nextDouble();
            }
        }
    }

    public static void cetakMatriks(Matrix matriks){
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColums(); j++) {
                System.out.print(matriks.data[i][j]);
                System.out.print(" ");
            }
            System.out.println();    
        }
    }

    public static void bacaArray(double[] soal){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soal.length; i++) {
            soal[i] = sc.nextDouble();
        }
    }


}

