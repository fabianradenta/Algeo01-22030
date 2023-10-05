import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        int pilihan;
        Menu.displayWelcome();
        Scanner scanner = new Scanner(System.in);
        while (running){
            try {
                System.out.println();
                Menu.displayMainMenu();
                System.out.println();
                System.out.print("Masukkan pilihan menu yang ingin dijalankan\t: ");
                pilihan = scanner.nextInt();
                while (pilihan<1 || pilihan>8){
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
                            System.out.println(MetodeOBE.gaussSPL(matr));

                            Menu.displayMenuOutput();
                            System.out.println();
                            System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                            int pilihanOutput;
                            pilihanOutput = scanner.nextInt();
                            while (pilihanOutput!=1 && pilihanOutput!=2){
                                System.out.println("Masukan output tidak valid. Silakan ulangi");
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                pilihanOutput = scanner.nextInt();
                            }
                            if (pilihanOutput==1){
                                IO.pWriteString(MetodeOBE.gaussSPL(matr));
                            }
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            IO.pReadMatrix(matr);
                            System.out.println();
                            System.out.println(MetodeOBE.gaussSPL(matr));

                            Menu.displayMenuOutput();
                            System.out.println();
                            System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                            int pilihanOutput;
                            pilihanOutput = scanner.nextInt();
                            while (pilihanOutput!=1 && pilihanOutput!=2){
                                System.out.println("Masukan output tidak valid. Silakan ulangi");
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                pilihanOutput = scanner.nextInt();
                            }
                            if (pilihanOutput==1){
                                IO.pWriteString(MetodeOBE.gaussSPL(matr));
                            }
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
                            System.out.println(MetodeOBE.gaussJordanSPL(matr));

                            Menu.displayMenuOutput();
                            System.out.println();
                            System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                            int pilihanOutput;
                            pilihanOutput = scanner.nextInt();
                            while (pilihanOutput!=1 && pilihanOutput!=2){
                                System.out.println("Masukan output tidak valid. Silakan ulangi");
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                pilihanOutput = scanner.nextInt();
                            }
                            if (pilihanOutput==1){
                                IO.pWriteString(MetodeOBE.gaussJordanSPL(matr));
                            }
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            IO.pReadMatrix(matr);
                            System.out.println();
                            System.out.println(MetodeOBE.gaussJordanSPL(matr));
   
                            Menu.displayMenuOutput();
                            System.out.println();
                            System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                            int pilihanOutput;
                            pilihanOutput = scanner.nextInt();
                            while (pilihanOutput!=1 && pilihanOutput!=2){
                                System.out.println("Masukan output tidak valid. Silakan ulangi");
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                pilihanOutput = scanner.nextInt();
                            }
                            if (pilihanOutput==1){
                                IO.pWriteString(MetodeOBE.gaussJordanSPL(matr));
                            }
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
                                    Menu.displayMenuOutput();
                                    System.out.println();
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    int pilihanOutput;
                                    pilihanOutput = scanner.nextInt();
                                    while (pilihanOutput!=1 && pilihanOutput!=2){
                                        System.out.println("Masukan output tidak valid. Silakan ulangi");
                                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                        pilihanOutput = scanner.nextInt();
                                    }
                                    if (pilihanOutput==1){
                                        IO.pWriteString(Inverse.displayInverse(resMatr));
                                    }
                                }
                            }
                            else {
                                System.out.println("Matriks dengan ukuran " + mInverse + "x" + nInverse + "tidak dapat dicari solusinya dengan metode matriks balikan");
                                System.out.println();
                            }
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            IO.pReadMatrix(matr);
                            if (matr.getRows()!=matr.getColumns()-1){
                                System.out.println("Matriks dengan ukuran " + matr.getRows() + "x" + matr.getRows() + "tidak dapat dicari solusinya dengan metode matriks balikan");
                                System.out.println();
                            }
                            else {
                                Matrix resMatr = new Matrix(matr.getColumns(),matr.getColumns());
                                resMatr = Inverse.SPLMatrix(matr);
                                System.out.println(Inverse.displayInverse(resMatr));
                                Menu.displayMenuOutput();
                                System.out.println();
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                int pilihanOutput;
                                pilihanOutput = scanner.nextInt();
                                while (pilihanOutput!=1 && pilihanOutput!=2){
                                    System.out.println("Masukan output tidak valid. Silakan ulangi");
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    pilihanOutput = scanner.nextInt();
                                }
                                if (pilihanOutput==1){
                                    IO.pWriteString(Inverse.displayInverse(resMatr));
                                }
                            }
                        }
                    } 
                    else {      // cramer
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
                                    System.out.println("Sistem persamaan linear ini tidak dapat diselesaikan dengan kaidah cramer");
                                }
                                else {
                                    // cetak solusi ke terminal
                                    System.out.print(Kofaktor.cramer(matr));
                                    Menu.displayMenuOutput();
                                    System.out.println();
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    int pilihanOutput;
                                    pilihanOutput = scanner.nextInt();
                                    while (pilihanOutput!=1 && pilihanOutput!=2){
                                        System.out.println("Masukan output tidak valid. Silakan ulangi");
                                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                        pilihanOutput = scanner.nextInt();
                                    }
                                    if (pilihanOutput==1){
                                        IO.pWriteString(Kofaktor.cramer(matr));
                                    }
                                }
                            }
                            else {
                                System.out.println("Matriks dengan ukuran " + mCramer + "x" + nCramer + " tidak dapat dicari solusinya dengan kaidah cramer");
                            }
                        }
                        else {
                            Matrix matr = new Matrix(0, 0);
                            IO.pReadMatrix(matr);
                            if (matr.getRows()!=matr.getColumns()-1){
                                System.out.println("Matriks dengan ukuran " + matr.getRows() + "x" + matr.getRows() + "tidak dapat dicari solusinya dengan metode matriks balikan");
                                System.out.println();
                            }
                            else {
                                System.out.print(Kofaktor.cramer(matr));
                                Menu.displayMenuOutput();
                                System.out.println();
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                int pilihanOutput;
                                pilihanOutput = scanner.nextInt();
                                while (pilihanOutput!=1 && pilihanOutput!=2){
                                    System.out.println("Masukan output tidak valid. Silakan ulangi");
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    pilihanOutput = scanner.nextInt();
                                }
                                if (pilihanOutput==1){
                                    IO.pWriteString(Kofaktor.cramer(matr));
                                }
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
                                System.out.println("Determinan dari matriks tersebut adalah " + MetodeOBE.determinanOBE(matr));
                                Menu.displayMenuOutput();
                                System.out.println();
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                int pilihanOutput;
                                pilihanOutput = scanner.nextInt();
                                while (pilihanOutput!=1 && pilihanOutput!=2){
                                    System.out.println("Masukan output tidak valid. Silakan ulangi");
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    pilihanOutput = scanner.nextInt();
                                }
                                if (pilihanOutput==1){
                                    IO.pWriteString(Kofaktor.cramer(matr));
                                }
                            }
                            else {
                                System.out.println("Determinan dari matriks tersebut adalah " + Kofaktor.determinanKofaktor(matr));
                                System.out.print(Kofaktor.cramer(matr));
                                Menu.displayMenuOutput();
                                System.out.println();
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                int pilihanOutput;
                                pilihanOutput = scanner.nextInt();
                                while (pilihanOutput!=1 && pilihanOutput!=2){
                                    System.out.println("Masukan output tidak valid. Silakan ulangi");
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    pilihanOutput = scanner.nextInt();
                                }
                                if (pilihanOutput==1){
                                    IO.pWriteString(Double.toString(Kofaktor.determinanKofaktor(matr)));
                                }

                            }
                        }            
                    }
                    else {
                        Matrix matr = new Matrix(0, 0);
                        IO.pReadMatrix(matr);
                        if (matr.rows!=matr.columns){
                            System.out.println("Matriks dengan ukuran " + matr.rows + "x" + matr.columns + " tidak memiliki determinan");
                            System.out.println();
                        }
                        else {
                            if (pilihanSubMenu==1){
                                System.out.println("Determinan dari matriks tersebut adalah " + MetodeOBE.determinanOBE(matr));
                                Menu.displayMenuOutput();
                                System.out.println();
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                int pilihanOutput;
                                pilihanOutput = scanner.nextInt();
                                while (pilihanOutput!=1 && pilihanOutput!=2){
                                    System.out.println("Masukan output tidak valid. Silakan ulangi");
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    pilihanOutput = scanner.nextInt();
                                }
                                if (pilihanOutput==1){
                                    IO.pWriteString(Double.toString(MetodeOBE.determinanOBE(matr)));
                                }
                            }
                            else {
                                System.out.println("Determinan dari matriks tersebut adalah " + Kofaktor.determinanKofaktor(matr));
                                Menu.displayMenuOutput();
                                System.out.println();
                                System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                int pilihanOutput;
                                pilihanOutput = scanner.nextInt();
                                while (pilihanOutput!=1 && pilihanOutput!=2){
                                    System.out.println("Masukan output tidak valid. Silakan ulangi");
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    pilihanOutput = scanner.nextInt();
                                }
                                if (pilihanOutput==1){
                                    IO.pWriteString(Double.toString(MetodeOBE.determinanOBE(matr)));
                                }
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
                        IO.pReadMatrix(matr);
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
                                    Menu.displayMenuOutput();
                                    System.out.println();
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    int pilihanOutput;
                                    pilihanOutput = scanner.nextInt();
                                    while (pilihanOutput!=1 && pilihanOutput!=2){
                                        System.out.println("Masukan output tidak valid. Silakan ulangi");
                                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                        pilihanOutput = scanner.nextInt();
                                    }
                                    if (pilihanOutput==1){
                                        IO.pWriteMatrix(MetodeOBE.balikanOBE(matr));
                                    }
                                }
                                else {
                                    matr.inverseWithAdjoint().displayMatrix();
                                    System.out.println();
                                    Menu.displayMenuOutput();
                                    System.out.println();
                                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                    int pilihanOutput;
                                    pilihanOutput = scanner.nextInt();
                                    while (pilihanOutput!=1 && pilihanOutput!=2){
                                        System.out.println("Masukan output tidak valid. Silakan ulangi");
                                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                                        pilihanOutput = scanner.nextInt();
                                    }
                                    if (pilihanOutput==1){
                                        IO.pWriteMatrix(matr.inverseWithAdjoint());
                                    }
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
                        int nTitik = scanner.nextInt();
                        Matrix matr = new Matrix(nTitik, 2);
                        matr.readMatrix();
                        Double res = InterpolasiPolinom.polinomInterpolation(InterpolasiPolinom.matrixGenerator(matr));
                        String strRes = Double.toString(res);
                        System.out.println(strRes);
                        Menu.displayMenuOutput();
                        System.out.println();
                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                        int pilihanOutput;
                        pilihanOutput = scanner.nextInt();
                        while (pilihanOutput!=1 && pilihanOutput!=2){
                            System.out.println("Masukan output tidak valid. Silakan ulangi");
                            System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                            pilihanOutput = scanner.nextInt();
                        }
                        if (pilihanOutput==1){
                            IO.pWriteString(strRes);
                        }
                    }
                    else {
                        Matrix matr = new Matrix(0, 0);
                        IO.pReadMatrix(matr);
                        Double res = InterpolasiPolinom.polinomInterpolation(InterpolasiPolinom.matrixGenerator(matr));
                        String strRes = Double.toString(res);
                        System.out.println(strRes);
                        Menu.displayMenuOutput();
                        System.out.println();
                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                        int pilihanOutput;
                        pilihanOutput = scanner.nextInt();
                        while (pilihanOutput!=1 && pilihanOutput!=2){
                            System.out.println("Masukan output tidak valid. Silakan ulangi");
                            System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                            pilihanOutput = scanner.nextInt();
                        }
                        if (pilihanOutput==1){
                            IO.pWriteString(strRes);
                        }
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
                    String strResult =BicubicSplineInterpolation.driverBicubic(parameterInput);
                    System.out.println(strResult);
                    Menu.displayMenuOutput();
                    System.out.println();
                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                    int pilihanOutput;
                    pilihanOutput = scanner.nextInt();
                    while (pilihanOutput!=1 && pilihanOutput!=2){
                        System.out.println("Masukan output tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                        pilihanOutput = scanner.nextInt();
                    }
                    if (pilihanOutput==1){
                        IO.pWriteString(strResult);
                    }
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
                    String strResult = RegresiLinearBerganda.driverRegresi(parameterInput);
                    System.out.println(strResult);
                    Menu.displayMenuOutput();
                    System.out.println();
                    System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                    int pilihanOutput;
                    pilihanOutput = scanner.nextInt();
                    while (pilihanOutput!=1 && pilihanOutput!=2){
                        System.out.println("Masukan output tidak valid. Silakan ulangi");
                        System.out.print("Masukkan pilihan output yang ingin dijalankan\t: ");
                        pilihanOutput = scanner.nextInt();
                    }
                    if (pilihanOutput==1){
                        IO.pWriteString(strResult);
                    }
                }
                else if (pilihan==7){
                    System.out.println("Upgrade ke versi premium untuk menggunakan pilihan ini ˶ᵔ ᵕ ᵔ˶");
                }
                else {
                    System.out.println();
                    Menu.displayThanks();
                    running = false;
                    scanner.close();
                }
            } catch (InputMismatchException e){
                System.out.println();
                System.out.println("Masukan tidak valid. Silakan ulangi.");
                scanner.nextLine();
            }
        }
    }
}