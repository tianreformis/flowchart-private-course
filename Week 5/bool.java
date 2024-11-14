public class bool {
    public static void main(String[] args) {
        int angka1=9;
        int angka2=10;
        boolean angka3=true;
        boolean negasi = !angka3;

        boolean kalimat1 = true;
        boolean kalimat2 = true;

        System.out.println(angka1 != angka2);
        System.out.println(negasi);
        System.out.println(kalimat1 || kalimat2);

    }
}


//Operator Logika
// && and ||

/*Syarat or 
 * true || true = true =  = 1 + 1 = 10
 * * true || false = true
 * * false || true = true

 * * false|| false= false
 * 
 * true || true || true = 1 + 1 + 1 = (desimal = 3) = 11
*/
/*
 * true 1 
false 0
||  logika or sama dengan penjumlahan
&&  logika and sama dengan perkalian
 * 
*/
/*
Syarat and


 * true && true  = true
 * true && false  = false
 * false && true  = false
 * false && false   = false
 * true && true && false = 1 * 1 * 0 = 0
 * 
*/