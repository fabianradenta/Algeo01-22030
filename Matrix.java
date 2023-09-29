//PROGRAM ADT MATRIX

import java.util.Scanner;
public class Matrix {
    public int rows;
    public int columns;
    public double[][] data;

    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public double getElmt(int i, int j){
        return this.data[i][j];
    }

    public int getLastIdxRow(){
        return rows-1;
    }

    public int getLastIdxCol(){
        return columns-1;
    }

    public boolean isIdxEff(int i, int j){
        return (i>=0 && i<=this.getLastIdxRow()) && (j>=0 && j<=this.getLastIdxCol());
    }

    public double getElmtDiagonal(int i){
        return this.data[i][i];
    }

    public void readMatrix(){
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<this.rows; i++){
            for (int j=0; j<this.columns; j++){
                this.data[i][j] = scanner.nextDouble();
            }
        }
        // scanner.close();
    }

    public void displayMatrix(){
        for (int i=0; i<this.rows; i++){
            for (int j=0; j<this.columns; j++){
                if (j==this.getLastIdxRow()){
                    System.out.println(data[i][j]);
                }
                else {
                    System.out.print(data[i][j] + " ");
                }
            }
        }
    }

    public void transpose(){
        double temp;
        for (int i=0; i<rows; i++){
            for (int j=i+1; j<columns; j++){
                temp = this.data[i][j];
                this.data[i][j] = this.data[j][i];
                this.data[j][i] = temp;
            }
        }
    }

    public void multiplyByConstant(double constant){
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                this.data[j][i] *= constant;
            }
        }
    }

    public boolean isMatrixSizeEqual(Matrix m2){
        return this.rows==m2.rows && this.columns==m2.columns;
    }

    public void copyMatrix(Matrix mOut){
        if (isMatrixSizeEqual(mOut)){ //periksa apakah ukuran matrix sama
            for (int i=0; i<this.rows; i++){
                for (int j=0; j<this.columns; j++){
                    mOut.data[i][j] = this.data[i][j];
                }
            }
        }
        else {
            System.out.println("Ukuran kedua matrix tidak sama"); // ini ga kepake sih kayanya
        }
    }
    
    public void addMatrix(Matrix m2){
        if (isMatrixSizeEqual(m2)){ //periksa apakah ukuran matrix sama
            for (int i=0; i<this.rows; i++){
                for (int j=0; j<this.columns; j++){
                    this.data[i][j] += m2.data[i][j];
                }
            }
        }
        else {
            System.out.println("Ukuran kedua matrix tidak sama");   // ini juga ga kepake harusnya
        }
    }
    
    public void subtractMatrix(Matrix m2){
        if (isMatrixSizeEqual(m2)){ //periksa apakah ukuran matrix sama
            for (int i=0; i<this.rows; i++){
                for (int j=0; j<this.columns; j++){
                    this.data[i][j] -= m2.data[i][j];
                }
            }
        }
        else {
            System.out.println("Ukuran kedua matrix tidak sama"); // ini juga ga kepake harusnya
        }
    }

    public void multiplyMatrix(Matrix m2){
        if (this.columns==m2.rows){ //periksa apakah ukuran matrix sama
            Matrix mHasil = new Matrix(this.rows, m2.columns);
            for (int i=0; i<this.rows; i++){
                for (int j=0; j<m2.columns; j++){
                    int hasilJumlah = 0;
                    for (int k=0; k<this.columns; k++){
                        hasilJumlah += this.data[i][k]*m2.data[k][j];
                    }
                mHasil.data[i][j] = hasilJumlah;
                }
            }
            this.rows = mHasil.rows;
            this.columns = mHasil.columns;
            for (int i=0; i<this.rows; i++){
                for (int j=0; j<this.columns; j++){
                    this.data[i][j] = mHasil.data[i][j];
                }
            }
        }
        else {
            System.out.println("perkalian tidak bisa dilakukan");
        }
    }
}
