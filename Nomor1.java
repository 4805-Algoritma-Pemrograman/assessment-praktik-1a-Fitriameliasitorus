import java.util.Scanner;

public class honorLembur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;

        System.out.print("Masukkan total jam lembur: ") ;
        int jamLembur = scanner.nextInt() ;
        double honorLembur;


        if (jamLembur <= 16) {
            honorLembur = jamLembur * 10000 ;
        } else {
            // Honor lembur untuk 16 jam pertama
            double honor16Jam = 16 * 10000 ;
            // Hitung sisa jam lembur
            int sisaJam = jamLembur - 16 ;
            // Honor lembur untuk sisa jam
            double honorSisaJam = sisaJam * 15000 ;
            // Total honor lembur
            honorLembur = honor16Jam + honorSisaJam;
        }

 
        System.out.println("Total jam lembur: " + jamLembur) ;
        System.out.println("Honor lembur: " + honorLembur) ;

        scanner.close();
}
}

