import java.util.*;

import javax.security.auth.Subject;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        int pilihan;
        Menu.displayWelcome();
        while (running){
            Menu.displayMainMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.print("Masukkan pilihan menu yang ingin dijalankan\t: ");
            pilihan = scanner.nextInt();
            while (pilihan<1 || pilihan>8){
                System.out.println("Masukan tidak valid. Silakan ulangi");
                System.out.print("Masukkan pilihan menu yang ingin dijalankan\t: ");
                pilihan = scanner.nextInt();
            }
            
            if (pilihan==1){
                int pilihanSubMenu;
                System.out.println();
                Menu.displayMenuSPL();
                System.out.println();
                System.out.print("Masukkan pilihan sub-menu yang ingin dijalankan\t: ");

                pilihanSubMenu = scanner.nextInt();
                while (pilihanSubMenu!=1 && pilihanSubMenu!=2 && pilihanSubMenu!=3 && pilihanSubMenu!=4){
                    System.out.println("Masukan sub-menu tidak valid. Silakan ulangi");
                    System.out.print("Masukkan pilihan sub-menu yang ingin dijalankan\t: ");
                    pilihanSubMenu = scanner.nextInt();
                }
                    if (pilihanSubMenu==1){ // eliminasi gauss
                        
                    }
                    else if (pilihanSubMenu==2){  //eliminasi gauss jordan

                    }
                        
                    else if (pilihanSubMenu==3){   //inverse method
                        int mInverse,nInverse;
                        System.out.print("Masukkan jumlah baris matriks\t:");
                        mInverse = scanner.nextInt();
                        System.out.print("Masukkan jumlah kolom matriks\t:");
                        nInverse = scanner.nextInt();
                        if (nInverse==mInverse+1){
                            Matrix matr = new Matrix(mInverse, nInverse);
                            Matrix resMatr = new Matrix(mInverse, nInverse);
                            matr.readMatrix(scanner);
                            resMatr = SPL.SPLMatrix(matr);
                            if (resMatr==null){
                                //keluarkan pesan bahwa spl tidak dapat dihandle dengan metode ini
                                System.out.println("Sistem persamaan linear ini tidak dapat diselesaikan dengan metode matriks balikan");
                            }
                            else {
                                //cetak solusi ke terminal
                                //belum dibuat program outputnya hehe, sementara cetak matriks hasilnya dulu aja
                                SPL.displayInverse(resMatr);
                            }
                        }
                        else {
                            System.out.println("Matriks dengan ukuran " + mInverse + "x" + nInverse + "tidak dapat dicari solusinya dengan metode matriks balikan");
                        }
                    } 
                    else {
                        int mCramer,nCramer;
                        System.out.print("Masukkan jumlah baris matriks\t:");
                        mCramer = scanner.nextInt();
                        System.out.print("Masukkan jumlah kolom matriks\t:");
                        nCramer = scanner.nextInt();
                        if (nCramer==mCramer+1){
                            Matrix matr = new Matrix(mCramer, nCramer);
                            matr.readMatrix(scanner);
                            if (Kofaktor.cramer(matr)==null){
                                //keluarkan pesan bahwa spl tidak dapat dihandle dengan metode ini
                                System.out.println("Sistem persamaan linear ini tidak dapat diselesaikan dengan metode matriks balikan");
                            }
                            else {
                                // cetak solusi ke terminal
                                System.out.print(Kofaktor.cramer(matr));
                            }
                        }
                        else {
                            System.out.println("Matriks dengan ukuran " + mCramer + "x" + nCramer + " tidak dapat dicari solusinya dengan kaidah cramer");
                        }
                    }
                
            }
        }
    }
}                     