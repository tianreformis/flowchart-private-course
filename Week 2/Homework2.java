import java.util.Scanner;
public class Homework2 {
    public static void main(String[] args){
        Scanner input_uang_saku = new Scanner(System.in); 

        System.out.println("Masukkan Uang Saku");
        int uang_saku = input_uang_saku.nextInt();
        int hargaPerPack=7500;
        int lembarPerPack = 100;
        int packBisaDibeli = uang_saku/hargaPerPack;
        int kembalian = uang_saku % hargaPerPack;
        
        System.out.println("Eileen can Buy "+packBisaDibeli+" Packs of binder paper");
        System.out.println("Change Received : Rp."+kembalian);


    
    }
}
