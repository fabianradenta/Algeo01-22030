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
        return this.rows-1;
    }

    public int getRows(){
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    public int getLastIdxCol(){
        return this.columns-1;
    }

    public boolean isIdxEff(int i, int j){
        return (i>=0 && i<=getLastIdxRow()) && (j>=0 && j<=getLastIdxCol());
    }

    public double getElmtDiagonal(int i){
        return this.data[i][i];
    }

    public void readMatrix(Scanner scanner){
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
                if (j==this.getLastIdxCol()){
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

    public void pMultiplyByConstant(double constant){
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                this.data[j][i] *= constant;
            }
        }
    }

    public Matrix multiplyByConstant(double constant){
        Matrix mHasil = new Matrix(this.rows, this.columns);
        this.copyMatrix(mHasil);
        for (int i=0; i<rows; i++){
            for (int j=0; j<columns; j++){
                mHasil.data[j][i] *= constant;
            }
        }
        return mHasil;
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

    public void pMultiplyMatrix(Matrix m2){
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
    
    public Matrix multiplyMatrix(Matrix m2){
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
            return mHasil;
        }
        else {
            return null;
        }
    }


    public double determinant() {
        if (rows != columns) {
            System.out.println("Determinant is only defined for square matrices.");
            return Double.NaN; // Return Not-a-Number to indicate an error
        }
    
        if (rows == 1) {
            return data[0][0]; // For a 1x1 matrix, the determinant is the only element
        }
    
        if (rows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0]; // For a 2x2 matrix, use the formula
        }
    
        double det = 0;
        for (int j = 0; j < columns; j++) {
            Matrix minorMatrix = new Matrix(rows - 1, columns - 1);
            for (int i = 1; i < rows; i++) {
                for (int k = 0, l = 0; k < columns; k++) {
                    if (k == j) continue;
                    minorMatrix.data[i - 1][l++] = data[i][k];
                }
            }
            double minorDeterminant = minorMatrix.determinant();
            det += data[0][j] * Math.pow(-1, j) * minorDeterminant;
        }
    
        return det;
    }    
    public Matrix cofactor() {
        int n = rows;
        if (n != columns) {
            System.out.println("Cofactor is only defined for square matrices.");
            return null; // Return null to indicate an error
        }
    
        Matrix cofactorMatrix = new Matrix(n, n);
    
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Matrix minorMatrix = new Matrix(n - 1, n - 1);
                int minorRow = 0;
    
                for (int k = 0; k < n; k++) {
                    if (k == i) continue;
                    int minorCol = 0;
    
                    for (int l = 0; l < n; l++) {
                        if (l == j) continue;
                        minorMatrix.data[minorRow][minorCol] = data[k][l];
                        minorCol++;
                    }
                    minorRow++;
                }
    
                double minorDeterminant = minorMatrix.determinant();
                cofactorMatrix.data[i][j] = Math.pow(-1, i + j) * minorDeterminant;
            }
        }
    
        return cofactorMatrix;
    }

    public Matrix adjoint(){
        Matrix mHasil = new Matrix(getRows(), getColumns());
        mHasil = this.cofactor();
        mHasil.transpose();
        return mHasil;
    }
    

    public Matrix inverseWithAdjoint(){
        if (this.determinant()!=0){
            Matrix mHasil = new Matrix(getRows(), getColumns());
            double constant = (1/this.determinant());
            mHasil = this.adjoint().multiplyByConstant(constant);
            return mHasil;
        }
        else {
            return null;
        }
    }

    public Matrix splitMatrixSoal(){
        Matrix mSoal = new Matrix(getRows(), getColumns());
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns()-1; j++) {
                mSoal.data[i][j] = this.data[i][j];
            }
        }
        return mSoal;
    }

    public Matrix splitMatrixHasil(){
        Matrix mHasil = new Matrix(getRows(), 1);
        for (int i = 0; i < getRows(); i++) {
            mHasil.data[i][getRows()] = this.data[i][getRows()];
        }
        return mHasil;
    }

    // public static void main(String[] args) {
    //     Matrix m = new Matrix(3, 3);
    //     m.readMatrix();

    //     System.out.println();
    //     System.out.print("determinan : ");
    //     System.out.println(m.determinant());
    //     System.out.println();
        
        
    //     System.out.println();
    //     System.out.println("adjoint : ");
    //     m.adjoint().displayMatrix();
    //     System.out.println();
        
    //     System.out.println();
    //     System.out.println("kofaktor : ");
    //     m.cofactor().displayMatrix();
    //     System.out.println();

    //     System.out.println();
    //     System.out.println("invers : ");
    //     m.inverseWithAdjoint().displayMatrix();
    //     System.out.println();
    // }
}
