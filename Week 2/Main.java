import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanAngka = new Scanner(System.in);
        float angka_pertama,angka_kedua;
        System.out.print("Enter the first Integer: ");
        angka_pertama = scanAngka.nextInt();
        System.out.print("Enter the first Integer: ");
        angka_kedua = scanAngka.nextInt();
        int sum =  (int) (angka_pertama + angka_kedua);
        int difference = (int) (angka_pertama - angka_kedua);
        int product = (int) (angka_pertama * angka_kedua);
        float qoutient = angka_pertama / angka_kedua;
        System.out.println("The sum is: "+sum); // true
        System.out.println("The difference is: "+difference); // true
        System.out.println("The product is: "+product); // true
        System.out.println("The quotient is: "+qoutient); // true
        
    }
}