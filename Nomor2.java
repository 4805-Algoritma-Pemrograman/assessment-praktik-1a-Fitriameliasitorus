import java.util.Scanner;

public class omsetkita {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int totalTripBeliau = 0, totalTripMereka = 0, totalTripKita = 0;
        String inputDriver;
        int jarakTrip;
        String inputLagi;
        final int BIAYA_PER_KM = 13000;

        // Input data driver
        do {
            System.out.print("Masukan nama driver [Beliau/Mereka/Kita]: ");
            inputDriver = scanner.nextLine();
            jarakTrip = getValidTripDistance(scanner);

            // Tambahkan jarak trip ke driver yang sesuai
            switch (inputDriver) {
                case "Beliau":
                    totalTripBeliau += jarakTrip;
                    break;
                case "Mereka":
                    totalTripMereka += jarakTrip;
                    break;
                case "Kita":
                    totalTripKita += jarakTrip;
                    break;
                default:
                    System.out.println("Nama driver tidak valid.");
                    continue;
            }

            inputLagi = getValidInputLagi(scanner);
        }
        while (inputDriver.equalsIgnoreCase("Y"));
    

        // Hitung omzet untuk setiap driver
        int omzetBeliau = totalTripBeliau * BIAYA_PER_KM;
        int omzetMereka = totalTripMereka * BIAYA_PER_KM;
        int omzetKita = totalTripKita * BIAYA_PER_KM;

        // Hitung total trip
        int totalTrip = totalTripBeliau + totalTripMereka + totalTripKita;

      
        String driverTertinggi = "Tidak ada";
        int omzetTertinggi = Math.max(omzetBeliau, Math.max(omzetMereka, omzetKita));

        if (omzetBeliau == omzetTertinggi) driverTertinggi = "Beliau";
        else if (omzetMereka == omzetTertinggi) driverTertinggi = "Mereka";
        else if (omzetKita == omzetTertinggi) driverTertinggi = "Kita";

        // Output hasil
        System.out.println("Total trip yang dilakukan driver = " + totalTrip);
        System.out.println("Omzet tertinggi diperoleh oleh " + driverTertinggi + " dengan total Omzet = " + omzetTertinggi);

       
        scanner.close();
    }

    private static int getValidTripDistance(Scanner scanner) {
        int distance;
        while (true) {
            System.out.print("Lama trip (km): ");
            if (scanner.hasNextInt()) {
                distance = scanner.nextInt();
                if (distance > 0) {
                    scanner.nextLine();
                    return distance;
                } else {
                    System.out.println("Jarak trip harus lebih besar dari 0. Silakan coba lagi.");
                }
            } else {
                System.out.println("Input tidak valid. Silakan masukkan angka.");
                scanner.next();
            }
        }
    }

    private static String getValidInputLagi(Scanner scanner) {
        String inputLagi;
        while (true) {
            System.out.print("Input lagi (Y/N)?: ");
            inputLagi = scanner.nextLine();
            if (inputLagi.equalsIgnoreCase("Y") || inputLagi.equalsIgnoreCase("N")) {
                return inputLagi;
            } else {
                System.out.println("Input tidak valid. Silakan masukkan 'Y' atau 'N'.");
    }
}
}
}

