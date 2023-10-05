import java.util.*;

import javax.lang.model.util.ElementScanner14;
import javax.security.auth.Subject;
import javax.xml.catalog.Catalog;

// import com.apple.laf.AquaImageFactory.NineSliceMetrics;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        int pilihan;
        Menu.displayWelcome();
        Scanner scanner = new Scanner(System.in);
        try {
            while (running){
                System.out.println();
                Menu.displayMainMenu();
                System.out.println();
                System.out.print("Masukkan pilihan menu yang ingin dijalankan\t: ");
                pilihan = scanner.nextInt();
                while (pilihan<1 || pilihan>7){
                    System.out.println("Masukan tidak valid. Silakan ulangi");
                    System.out.print("Masukkan pilihan menu yang ingin dijalankan\t: ");
                    pilihan = scanner.nextInt();
                }
                
                if (pilihan==1){    // spl
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
                        int pilihanInput;
                        Menu.displayMenuInput();
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                        while (pilihanInput!=1 && pilihanInput!=2){
                            System.out.println("Masukan tidak valid. Silakan ulangi");
                            System.out.print("Masukkan pilihan input\t: ");
                            pilihanInput = scanner.nextInt();
                        }

                        if (pilihanInput==1){
                            int mGauss, nGauss;
                            System.out.println();
                            System.out.print("Masukkan jumlah baris matriks\t: ");
                            mGauss = scanner.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks\t: ");
                            nGauss = scanner.nextInt();
                            System.out.println();
                            Matrix matr = new Matrix(mGauss, nGauss);
                            matr.readMatrix();
                            System.out.println();
                            MetodeOBE.gaussSPL(matr);   //mau diganti dari void jadi String supaya bisa di write ke file
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            matr = InputOutput.readMatrixFromFile();
                            System.out.println();
                            MetodeOBE.gaussSPL(matr);
                        }

                    }
                    else if (pilihanSubMenu==2){  //eliminasi gauss jordan
                        int pilihanInput;
                        Menu.displayMenuInput();
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                        while (pilihanInput!=1 && pilihanInput!=2){
                            System.out.println("Masukan tidak valid. Silakan ulangi");
                            System.out.print("Masukkan pilihan input\t: ");
                            pilihanInput = scanner.nextInt();
                        }
                        if (pilihanInput==1){
                            int mGaussJordan, nGaussJordan;
                            System.out.println();
                            System.out.print("Masukkan jumlah baris matriks\t: ");
                            mGaussJordan = scanner.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks\t: ");
                            nGaussJordan = scanner.nextInt();
                            System.out.println();

                            Matrix matr = new Matrix(mGaussJordan, nGaussJordan);
                            matr.readMatrix();
                            System.out.println();
                            MetodeOBE.gaussJordanSPL(matr);
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            matr = InputOutput.readMatrixFromFile();
                            System.out.println();
                            MetodeOBE.gaussJordanSPL(matr);
                        }
                    }
                        
                    else if (pilihanSubMenu==3){   //inverse method
                        int pilihanInput;
                        Menu.displayMenuInput();
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                        while (pilihanInput!=1 && pilihanInput!=2){
                            System.out.println("Masukan tidak valid. Silakan ulangi");
                            System.out.print("Masukkan pilihan input\t: ");
                            pilihanInput = scanner.nextInt();
                        }

                        if (pilihanInput==1){
                            int mInverse,nInverse;
                            System.out.print("Masukkan jumlah baris matriks\t: ");
                            mInverse = scanner.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks\t: ");
                            nInverse = scanner.nextInt();
                            if (nInverse==mInverse+1){
                                Matrix matr = new Matrix(mInverse, nInverse);
                                Matrix resMatr = new Matrix(mInverse, nInverse);
                                matr.readMatrix();
                                System.out.println();
                                resMatr = Inverse.SPLMatrix(matr);
                                if (resMatr==null){
                                    //keluarkan pesan bahwa spl tidak dapat dihandle dengan metode ini
                                    System.out.println("Sistem persamaan linear ini tidak dapat diselesaikan dengan metode matriks balikan");
                                }
                                else {
                                    System.out.println(Inverse.displayInverse(resMatr));
                                }
                            }
                            else {
                                System.out.println("Matriks dengan ukuran " + mInverse + "x" + nInverse + "tidak dapat dicari solusinya dengan metode matriks balikan");
                                System.out.println();
                            }
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            matr = InputOutput.readMatrixFromFile();
                            if (matr.getRows()!=matr.getColumns()-1){
                                System.out.println("Matriks dengan ukuran " + matr.getRows() + "x" + matr.getRows() + "tidak dapat dicari solusinya dengan metode matriks balikan");
                                System.out.println();
                            }
                            else {
                                Matrix resMatr = new Matrix(matr.getColumns(),matr.getColumns());
                                resMatr = Inverse.SPLMatrix(matr);
                                System.out.println(Inverse.displayInverse(resMatr));
                            }
                        }
                    } 
                    else {
                        int pilihanInput;
                        Menu.displayMenuInput();
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                        while (pilihanInput!=1 && pilihanInput!=2){
                            System.out.println("Masukan tidak valid. Silakan ulangi");
                            System.out.print("Masukkan pilihan input\t: ");
                            pilihanInput = scanner.nextInt();
                        }
                        if (pilihanInput==1){
                            int mCramer,nCramer;
                            System.out.print("Masukkan jumlah baris matriks\t: ");
                            mCramer = scanner.nextInt();
                            System.out.print("Masukkan jumlah kolom matriks\t: ");
                            nCramer = scanner.nextInt();
                            if (nCramer==mCramer+1){
                                Matrix matr = new Matrix(mCramer, nCramer);
                                matr.readMatrix();
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
                        else {
                            Matrix matr = new Matrix(0, 0);
                            matr = InputOutput.readMatrixFromFile();
                            if (matr.getRows()!=matr.getColumns()-1){
                                System.out.println("Matriks dengan ukuran " + matr.getRows() + "x" + matr.getRows() + "tidak dapat dicari solusinya dengan metode matriks balikan");
                                System.out.println();
                            }
                            else {
                                System.out.print(Kofaktor.cramer(matr));
                            }
                        }
                    }
                }
                else if (pilihan==2){   // determinan
                    System.out.println();
                    Menu.displayMenuDet();
                    System.out.println();
                    System.out.print("Masukkan pilihan sub-menu yang ingin dijalankan\t: ");
                    int pilihanSubMenu;

                    pilihanSubMenu = scanner.nextInt();
                    while (pilihanSubMenu!=1 && pilihanSubMenu!=2){
                        System.out.println("Masukan sub-menu tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan sub-menu yang ingin dijalankan\t: ");
                        pilihanSubMenu = scanner.nextInt();
                    }
                    
                    int pilihanInput;
                    Menu.displayMenuInput();
                    System.out.print("Masukkan pilihan input\t: ");
                    pilihanInput = scanner.nextInt();
                    while (pilihanInput!=1 && pilihanInput!=2){
                        System.out.println("Masukan tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                    }
                    if (pilihanInput==1){
                        int mDeterminant,nDeterminant;
                        System.out.print("Masukkan jumlah baris matriks\t: ");
                        mDeterminant = scanner.nextInt();
                        System.out.print("Masukkan jumlah kolom matriks\t: ");
                        nDeterminant = scanner.nextInt();
                        System.out.println();
                        
                        if (mDeterminant!=nDeterminant){
                            System.out.println("Matriks dengan ukuran " + mDeterminant + "x" + nDeterminant + " tidak memiliki determinan");
                            System.out.println();
                        }
                        else {
                            Matrix matr = new Matrix(mDeterminant, nDeterminant);
                            matr.readMatrix();
                            System.out.println();
                            if (pilihanSubMenu==1){
                                System.out.print("Determinan dari matriks tersebut adalah " + MetodeOBE.determinanOBE(matr));
                                System.out.println();
                            }
                            else {
                                System.out.print("Determinan dari matriks tersebut adalah " + Kofaktor.determinanKofaktor(matr));
                                System.out.println();
                            }
                        }            
                    }
                    else {
                        Matrix matr = new Matrix(0, 0);
                        matr = InputOutput.readMatrixFromFile();
                        if (matr.rows!=matr.columns){
                            System.out.println("Matriks dengan ukuran " + matr.rows + "x" + matr.columns + " tidak memiliki determinan");
                            System.out.println();
                        }
                        else {
                            if (pilihanSubMenu==1){
                                System.out.print("Determinan dari matriks tersebut adalah " + MetodeOBE.determinanOBE(matr));
                                System.out.println();
                            }
                            else {
                                System.out.print("Determinan dari matriks tersebut adalah " + Kofaktor.determinanKofaktor(matr));
                                System.out.println();
                            }
                        }
                    }
                }
                else if (pilihan==3){   // matriks balikan
                    System.out.println();
                    Menu.displayMenuInverse();
                    System.out.println();
                    System.out.print("Masukkan pilihan sub-menu yang ingin dijalankan\t: ");
                    int pilihanSubMenu;

                    
                    pilihanSubMenu = scanner.nextInt();
                    while (pilihanSubMenu!=1 && pilihanSubMenu!=2){
                        System.out.println("Masukan sub-menu tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan sub-menu yang ingin dijalankan\t: ");
                        pilihanSubMenu = scanner.nextInt();
                    }

                    int pilihanInput;
                    Menu.displayMenuInput();
                    System.out.print("Masukkan pilihan input\t: ");
                    pilihanInput = scanner.nextInt();
                    while (pilihanInput!=1 && pilihanInput!=2){
                        System.out.println("Masukan tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                    }
                    
                    if (pilihanInput==1){
                        int mInverse,nInverse;
                        System.out.println();
                        System.out.print("Masukkan jumlah baris matriks\t: ");
                        mInverse = scanner.nextInt();
                        System.out.print("Masukkan jumlah kolom matriks\t: ");
                        nInverse = scanner.nextInt();
                        System.out.println();
                        
                        if (mInverse!=nInverse){
                            System.out.println("Matriks dengan ukuran " + mInverse + "x" + nInverse + " tidak memiliki matriks balikan");
                            System.out.println();
                        }
                        else {
                            Matrix matr = new Matrix(mInverse, nInverse);
                            matr.readMatrix();
                            System.out.println();
                            if (matr.determinant()!=0){
                                System.out.println("Matriks balikan dari matriks tersebut adalah ");
                                System.out.println();
                                if (pilihanSubMenu==1){
                                    MetodeOBE.balikanOBE(matr).displayMatrix();
                                    System.out.println();
                                }
                                else {
                                    matr.inverseWithAdjoint().displayMatrix();
                                    System.out.println();
                                }
                            }
                            else {
                                System.out.println("Matriks ini tidak memiliki matriks balikan karena determinannya bernilai 0");
                            }
                        }
                    }
                    else {
                        Matrix matr = new Matrix(0, 0);
                        matr = InputOutput.readMatrixFromFile();
                        if (matr.rows!=matr.columns){
                            System.out.println("Matriks dengan ukuran " + matr.rows + "x" + matr.columns + " tidak memiliki matriks balikan");
                            System.out.println();
                        }
                        else {
                            System.out.println();
                            if (matr.determinant()!=0){
                                System.out.println("Matriks balikan dari matriks tersebut adalah ");
                                System.out.println();
                                if (pilihanSubMenu==1){
                                    MetodeOBE.balikanOBE(matr).displayMatrix();
                                    System.out.println();
                                }
                                else {
                                    matr.inverseWithAdjoint().displayMatrix();
                                    System.out.println();
                                }
                            }
                            else {
                                System.out.println("Matriks ini tidak memiliki matriks balikan karena determinannya bernilai 0");
                            }
                        }
                    }
                }
                else if (pilihan==4){   //interpolasi polinom
                    int pilihanInput;
                    Menu.displayMenuInput();
                    System.out.print("Masukkan pilihan input\t: ");
                    pilihanInput = scanner.nextInt();
                    while (pilihanInput!=1 && pilihanInput!=2){
                        System.out.println("Masukan tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                    }

                    if (pilihanInput==1){
                        System.out.print("Masukkan banyak titik\t: ");
                        scanner.nextInt();
                        //belum dilanjutin
                        //gatau cara make fungsinya :)
                    }
                    else {
                        Matrix matr = new Matrix(0, 0);
                        matr = InputOutput.readMatrixFromFile();
                        //belum dilanjutin
                        //gatau cara make fungsinya :)
                    }
                }
                else if (pilihan==5){   // interpolasi bicubic spline
                    int pilihanInput;
                    Menu.displayMenuInput();
                    System.out.print("Masukkan pilihan input\t: ");
                    pilihanInput = scanner.nextInt();
                    while (pilihanInput!=1 && pilihanInput!=2){
                        System.out.println("Masukan tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                    }
                    boolean parameterInput;
                    if (pilihan==1){
                        parameterInput = true;
                    }
                    else {
                        parameterInput = false;
                    }
                    driverBicubic(parameterInput);

                }
                else if (pilihan==6){   //regresi linear berganda
                    int pilihanInput;
                    Menu.displayMenuInput();
                    System.out.print("Masukkan pilihan input\t: ");
                    pilihanInput = scanner.nextInt();
                    while (pilihanInput!=1 && pilihanInput!=2){
                        System.out.println("Masukan tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan input\t: ");
                        pilihanInput = scanner.nextInt();
                    }
                    boolean parameterInput;
                    if (pilihan==1){
                        parameterInput = true;
                    }
                    else {
                        parameterInput = false;
                    }
                    driverRegresi(parameterInput);
                }
                else {
                    System.out.println();
                    Menu.displayThanks();
                    running = false;
                    scanner.close();
                }
            }
        } catch (Exception e){
            System.out.println("Something went wrong.");
        } finally {
            System.out.println("end of program ");
        }
    }
}