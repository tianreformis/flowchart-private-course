import java.util.Scanner;
public class Homework {
    public static void main(String[] args){
        Scanner scanAngka = new Scanner(System.in);
        int angka_pertama,angka_kedua;
        System.out.print("Enter the first Integer: ");
        angka_pertama = scanAngka.nextInt();
        System.out.print("Enter the second Integer: ");
        angka_kedua = scanAngka.nextInt();
        int hasil =  (int) angka_pertama+angka_kedua;
        System.out.print("Result: "+hasil);

    
    }
}
