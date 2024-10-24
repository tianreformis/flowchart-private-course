import java.util.Scanner;
public class Fibonnaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=0;
        while (true){
            System.out.println("Masukkan bilangan genap");
            n=scanner.nextInt();
            if (n < 0){
                System.out.println("Input harus positif");
            }
            else {
                break;
            }
        }
        System.out.println("Fibonancci ke "+n);
        int a=0;
        int b=1;

        for (int i = 1; i <=n; i++){
            System.out.print(a+ " ");
            int next = a+b;
            a=b;
            b=next;
        }
        System.out.println();
        
    }
}
