import java.util.Scanner;

public class MetodeOBE {

    public static void tukarBaris(Matrix matriks, int baris1, int baris2){
    // I.S. Matriks terdefinisi dan memiliki baris yang ingin ditukar
    // F.S. Baris pada matriks sudah ditukar
        for (int i = 0; i < matriks.getColumns(); i++) {
            double temp = matriks.data[baris1][i];
            matriks.data[baris1][i] = matriks.data[baris2][i];
            matriks.data[baris2][i] = temp;
        }
    }

    public static void kaliKonstan(Matrix matriks, double koef, int baris){
    // I.S. Matriks terdefinisi dan memiliki baris yang ingin dikali 1/koef
    // F.S. Menghasilkan baris dengan 1 Utama
        for (int i = baris; i < matriks.getColumns(); i++) {
            matriks.data[baris][i] = matriks.data[baris][i]/koef;    
        }
    }

    public static void operasiBaris(Matrix matriks, double koef, int baris1, int baris2){
    // I.S. Matriks terdefinisi dan memiliki baris yang ingin dioperasikan dengan koefisien tertentu
    // F.S. Baris sudah dioperasikan
        for (int i = 0; i < matriks.getColumns(); i++) {
            matriks.data[baris2][i] = matriks.data[baris2][i]-koef*matriks.data[baris1][i];
        } 
    }

    public static void matriksElimGauss(Matrix matriks) {
    // I.S. Matriks terdefinisi
    // F.S. Matriks diubah menjadi matriks eselon baris
        int idx1UtamaBaris=0;
        for (int i = 0; i < matriks.getColumns(); i++) {
            
            if (idx1UtamaBaris == matriks.getRows()) {
            // jika index baris terakhir sudah mendapatkan 1 utama
                break;
            }
 
        // Algoritma mencari 1 utama tiap baris
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
            // jika kolom j memiliki 1 utama atau tidak seluruhnya 0
                idx1UtamaBaris++;
            }
        }
    }

    public static double[] subtitusiMundur(Matrix matriks){
    // I.S. Matriks terdefinisi dan diharapkan sudah melewati prosedur eliminasi gauss
    // F.S. Mengembalikan array berisi solusi SPL
        double[] solusi = new double[matriks.getRows()];
        for (int i = matriks.getRows()-1; i >= 0; i--) {
            solusi[i] = matriks.data[i][matriks.getColumns()-1];
            for (int j = i+1; j < matriks.getColumns()-1; j++) {
                solusi[i]=solusi[i] - matriks.data[i][j]*solusi[j];
            }
        }
        return solusi;
    }

    public static void matriksElimGaussJordan(Matrix matriks){
    // I.S. Matriks terdefinisi
    // F.S. Matriks diubah menjadi matriks eselon baris tereduksi
        int idx1UtamaBaris = matriks.getLastIdxRow();
        int idx1UtamaKolom = matriks.getLastIdxCol();

    // Algoritma Eliminasi Gauss Jordan
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
    // I.S. Matriks terdefinisi dan diharapkan sudah melewati prosedur Eliminasi Gauss Jordan
    // F.S. Mengembalikan array berisi solusi SPL
        double[] solusi = new double[matriks.getRows()];
        for (int i = 0; i < matriks.getRows(); i++) {
            solusi[i] = matriks.data[i][matriks.getColumns()-1];
        }
        return solusi;
    }

    public static double determinanOBE(Matrix matriks){
    // Prekondisi : Matriks persegi
    // I.S. Matriks terdefinisi
    // F.S. Mengembalikan nilai determinan suatu matriks persegi
        int jmlTukar=0;
        int idx1UtamaBaris=0;
    
    // Algoritma mirip Eliminasi Gauss
        for (int i = 0; i < matriks.getColumns(); i++) {
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

    // Algoritma untuk mendapatkan determinan
        double det = 1;
        for (int i = 0; i < matriks.getRows() ; i++) {
            det = det*matriks.data[i][i];
        }
        det = det*Math.pow((-1), jmlTukar);
        return det;
    }

    public static Matrix balikanOBE(Matrix matriks){
    // Prekondisi : Matriks persegi
    // I.S. Matriks terdefinisi
    // F.S. Mengembalikan matriks balikan (invers) dari suatu matriks persegi
    // Algoritma matriks invers dengan Eliminasi Gauss Jordan
        Matrix matriksbalikan = new Matrix(matriks.getRows(), 2*matriks.getColumns());
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColumns() ; j++) {
                matriksbalikan.data[i][j]=matriks.data[i][j];
            }
            for (int k = matriks.getColumns(); k < 2*matriks.getColumns(); k++) {
                if (i + matriks.getColumns() == k){
                    matriksbalikan.data[i][k] = 1;
                } else {
                    matriksbalikan.data[i][k] = 0;
                }    
            }
        }
        matriksElimGaussJordan(matriksbalikan);
        for (int i = 0; i < matriks.getRows(); i++) {
            for (int j = 0; j < matriks.getColumns(); j++) {
                matriks.data[i][j]= matriksbalikan.data[i][j+matriks.getColumns()];
            }
        }
        return matriks;
    }
    
    public static String gaussSPL(Matrix matriks){
    // I.S. Matriks augmented terdefinisi
    // F.S. Mencetak solusi matriks augmented ke layar
        double det;
        double[] solusi;
        String fungsi = new String();
        Matrix cekmatriks = new Matrix(matriks.getRows(), matriks.getColumns()-1);
        for (int index = 0; index < matriks.getRows(); index++) {
            for (int i = 0; i < matriks.getColumns()-1; i++) {
              cekmatriks.data[index][i] = matriks.data[index][i]; 
            }
        }
        det = determinanOBE(cekmatriks);
        if (matriks.getRows() == (matriks.getColumns()-1) && det != 0) {
        // Matriks augmented memiliki solusi unik
            matriksElimGauss(matriks);
            solusi = subtitusiMundur(matriks);
            // cetakSolusi(solusi);
            for (int i = 0; i < solusi.length; i++) {
                fungsi = fungsi + String.format("x%d = %f\n", (i+1), solusi [i]);
                // System.out.print(solusi[i]);
                // if (i != solusi.length-1) {
                //     fungsi = fungsi + String.format(", ");
                // } else {
                //     fungsi = fungsi + String.format("\n");
                // }
            }
            
        } else {
        // Matriks singular
            boolean adaSolusi = true;
            matriksElimGaussJordan(matriks);
            //matriks.displayMatrix();
            int i=matriks.getRows()-1;
            while (i >-1 && !cekAda1Utama(matriks, i) && adaSolusi) {
                if (matriks.data[i][matriks.getColumns()-1] != 0) {
                    adaSolusi = false;
                } else
                i--;
            }
            if (adaSolusi) {
                fungsi = parametrik(matriks);
            } else {
                fungsi = ("Sistem Persamaan Linear Ini Tidak Memiliki Solusi");
            }
        }
        return fungsi;
    }

    public static String gaussJordanSPL(Matrix matriks){
        double det;
        double[] solusi;
        String fungsi = new String();
        Matrix cekmatriks = new Matrix(matriks.getRows(), matriks.getColumns()-1);
        for (int index = 0; index < matriks.getRows(); index++) {
            for (int i = 0; i < matriks.getColumns()-1; i++) {
              cekmatriks.data[index][i] = matriks.data[index][i]; 
            }
        }
        det = determinanOBE(cekmatriks);
        if (matriks.getRows() == matriks.getColumns()-1 && det != 0) {
            matriksElimGaussJordan(matriks);
            //matriks.displayMatrix();
            solusi = solusiGaussJordan(matriks);
            //cetakSolusi(solusi);
            for (int i = 0; i < solusi.length; i++) {
                fungsi = fungsi + String.format("x%d = %f\n", (i+1), solusi [i]);
            }
        } else {
            //System.out.println("TIDAK KONSISTEN");
            boolean adaSolusi = true;
            matriksElimGaussJordan(matriks);
            int i=matriks.getRows()-1;
            while (i >-1 && !cekAda1Utama(matriks, i) && adaSolusi) {
                if (matriks.data[i][matriks.getColumns()-1] != 0) {
                    adaSolusi = false;
                } else
                i--;
            }
            
            if (adaSolusi) {
                fungsi = parametrik(matriks);
            } else {
                fungsi = ("Sistem Persamaan Linear ini Tidak Memiliki Solusi");
            }
        }
        return fungsi;
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

    public static boolean cekAda1Utama(Matrix matriks, int i){
    // I.S. Matriks terdefinisi dan baris i terdefinisi
    // F.S. Mengembalikan true jika baris i memiliki 1 utama
        int j = 0;
        while (j<matriks.getColumns()-1 && matriks.data[i][j]==0 ) {
            j++;
        }
        if (j != matriks.getColumns()-1) {
            return true;
        } else {
            return false;
        }
    }

    public static int satupertamakolom(Matrix matriks, int i){
    // Prekondisi : baris i memiliki 1 utama
    // I.S. Matriks terdefinisi dan baris i terdefinisi
    // F.S. Mengembalikan indeks 1 Utama pada baris i
        int j = 0;
        while (j<matriks.getColumns()-1 && matriks.data[i][j]==0 ) {
            j++;
        }
        return j;
    }


    public static String parametrik(Matrix matriks){
    // I.S. Matriks singular terdefinisi
    // F.S. Mencetak persamaan parametrik ke layar
        double[] idksolusi = new double[matriks.getColumns()-1];
        String[] fungsi = new String[matriks.getColumns()-1];
        for (int i = 0; i < matriks.getRows(); i++) {
            if (cekAda1Utama(matriks, i)){
                int j = satupertamakolom(matriks, i);
                idksolusi[j] = 1;
            }
        }
        //cetakSolusi(idksolusi);
        for (int i = 0; i < idksolusi.length; i++) {
            if (idksolusi[i] == 0) {
                fungsi[i] = String.format("x%d = x%d",(i+1), (i+1));

            }
        }
        for (int i = 0; i < matriks.getRows(); i++) {
            if (cekAda1Utama(matriks, i)){
                fungsi[(satupertamakolom(matriks, i))] =String.format("x%d = %f " ,(satupertamakolom(matriks, i) +1), (matriks.data[i][matriks.getColumns()-1]));
                //System.out.print("x"+(satupertamakolom(matriks, i) +1)+" = "+ matriks.data[i][matriks.getColumns()-1] + " ");
                for (int j = satupertamakolom(matriks, i); j < matriks.getColumns() - 1; j++) {
                    //int k = 0;
                    if (idksolusi[j] != 1) {
                        if (matriks.data[i][j] > 0) {
                            fungsi[(satupertamakolom(matriks, i))] = fungsi[(satupertamakolom(matriks, i))] + String.format("- %f*x%d " , (matriks.data[i][j]) ,  (j+1));
                            //System.out.print("- " +matriks.data[i][j]+"*x" + (j+1) +" ");
                        } else if (matriks.data[i][j] < 0){
                            fungsi[(satupertamakolom(matriks, i))] = fungsi[(satupertamakolom(matriks, i))] + String.format("+ %f*x%d " , (matriks.data[i][j]) ,  (j+1));
                            //System.out.print("+ " +(-matriks.data[i][j])+"*x" + (j+1) +" ");
                        }                        
                    }
                }
                // System.out.println();
            }
        }
        String hasilparametrik = new String();
        for (int i = 0; i < fungsi.length; i++) {
            // System.out.print("x" + (i + 1) + " = ");
            // System.out.print(fungsi[i]);
            hasilparametrik = hasilparametrik + fungsi[i] + ("\n");
            // if (i != fungsi.length-1) {
            //     System.out.print("\n");
            // } else {
            //     System.out.println();
            // }
        }
        return hasilparametrik;
    }

    public static void bacaArray(double[] soal){
    // I.S. Sembarang
    // F.S. Telah membaca array
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < soal.length; i++) {
            soal[i] = sc.nextDouble();
        }
    }


}

