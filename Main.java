import java.util.*;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choice = -1;
        while (choice != 7) {
            System.out.println();
            System.out.println("*************************************************************************");
            System.out.println("                                 MENU");
            System.out.println("*************************************************************************");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks Balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic Spline");
            System.out.println("6. Regresi Linear Berganda");
            System.out.println("7. Perbesar Gambar");
            System.out.println("8. Keluar");
            System.out.print("Masukkan pilihan menu: ");
            System.out.println(" ");
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("*************************************************************************");
                    System.out.println("                            Terima Kasih  ");
                    System.out.println("*************************************************************************");
                    break;
                default:
                    System.out.println("Input tidak dikenali. Mohon hanya masukkan bilangan bulat antara 1-8.");
                    break;
            }
        }
    }
}                     