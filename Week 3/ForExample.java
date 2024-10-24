public class ForExample {
    public static void main(String[] args) {
        //for (batas bawah ; batas atas; konsep pengulangannya)
        //i++ = i + 1
        for (int i = 1; i <=10; i++){
            System.out.print(" "+i);
        }
        System.out.println("");
        int j = 1;
        do {
            System.out.print(" "+j);
            j++;
           
        } while (j <=5);

        for (int i = 1; i<=10; i++){
            System.out.print(" "+i*3);
        }
    }
}