import java.io.*;


public class Menu {

    // Welcoming Menu
    public static void displayWelcome() {
        System.out.println("=========================================================================");
        System.out.println(" "); 
        System.out.println("                              WELCOME TO"); 
        System.out.println(" ");       
        System.out.println("         IIII   N   N  FFFFF  IIIII  N   N  IIIII  TTTTT  Y   Y");
        System.out.println("          II    NN  N  F        I    NN  N    I      T     Y Y");
        System.out.println("          II    N N N  FFFF     I    N N N    I      T      Y");
        System.out.println("          II    N  NN  F        I    N  NN    I      T      Y");
        System.out.println("         IIII   N   N  F      IIIII  N   N  IIIII    T      Y");
        System.out.println(" "); 
    }

    // Daftar Menu Utama
    public static void displayMainMenu() {
        System.out.println("=========================================================================");
        System.out.println("                                 MENU");
        System.out.println("=========================================================================");
        System.out.println("1. Sistem Persamaan Linier");
        System.out.println("2. Determinan");
        System.out.println("3. Matriks Balikan");
        System.out.println("4. Interpolasi Polinom");
        System.out.println("5. Interpolasi Bicubic Spline");
        System.out.println("6. Regresi Linear Berganda");
        System.out.println("7. Perbesar Gambar");
        System.out.println("8. Keluar");
    }
    
    // Daftar Menu Utama -> SPL
    public static void displayMenuSPL(){
        System.out.println("=========================================================================");
        System.out.println("                     MENU SISTEM PERSAMAAN LINIER");
        System.out.println("=========================================================================");
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Eliminasi Gauss-Jordan");
        System.out.println("3. Metode Matriks Balikan");
        System.out.println("4. Kaidah Cramer");
    }

    // Daftar Menu Utama -> Determinan
    public static void displayMenuDet(){
        System.out.println("=========================================================================");
        System.out.println("                             MENU DETERMINAN");
        System.out.println("=========================================================================");
        System.out.println("1. Metode Eliminasi Gauss");
        System.out.println("2. Metode Ekspansi Kofaktor");
    }

    // Daftar Menu Utama -> Inverse
    public static void displayMenuInverse(){
        System.out.println("=========================================================================");
        System.out.println("                              MENU INVERSE");
        System.out.println("=========================================================================");
        System.out.println("1. Metode Eliminasi Gauss-Jordan");
        System.out.println("2. Metode Matriks Kofaktor");
    }

    // Daftar Menu Input Data
    public static void displayMenuInput(){
        System.out.println("=========================================================================");
        System.out.println("                        MENU INPUT DATA MATRIKS");
        System.out.println("=========================================================================");
        System.out.println("1. Input Keyboard");
        System.out.println("2. Input File");
    }

    // Daftar Menu Output Data
    public static void displayMenuOutput(){
        System.out.println("Apakah Anda ingin menyimpan hasil ini ke dalam file?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
    }

    // Thank You Menu
    public static void displayThanks() {
        System.out.println("=========================================================================");
        System.out.println("                            Terima Kasih");
        System.out.println("=========================================================================");
        System.out.println("===============================₊˚.⊹♡⊹.˚₊=================================");
    }
}