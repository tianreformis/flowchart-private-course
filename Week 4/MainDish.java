import java.util.Scanner;

public class MainDish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOrders;
        System.out.print("Masukkan Jumlah pesanan : ");
        numOrders = scanner.nextInt();

        int mainDishCount = 0;
        int snackCount = 0;

        for (int i = 0; i < numOrders; i++) {
            System.out.println("Food Menu");
            System.out.println("1. Nasi Goreng");
            System.out.println("2. Mie Goreng");
            System.out.println("3. Tahu Krispi");
            System.out.println("4. Tempe Mendoan");
            System.out.println("5. Kentang Goreng");

            int order;
            System.out.print("Masukkan nomor pesanan : ");
            order = scanner.nextInt();

            if (order >= 1 && order <= 5) {
                if (order == 1 || order == 2) {
                    mainDishCount++;
                    System.out.println(" Main Dish Dipesan");
                } else {
                    snackCount++;
                    System.out.println("Snack Dipesan");
                }

            }
            else {
                System.out.println("Angka diabaikan");
            }

            System.out.println("Jumlah Main Dish Dipesan : " + mainDishCount);
            System.out.println("Jumlah Snack Dipesan : " + snackCount);

        }

    }
}
