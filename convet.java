import java.util.*;
public class convet {
     public static int bintodec (int n){
          
          int dec=0;
        int pow=0;
            while(n>0){
                int lastno=n%10;
               
                dec=dec+lastno*(int)Math.pow(2,pow);
                pow++;
                n/=10;
            }
            return dec;
    }
    public static int dectobin(int n){
        int bin=0;
        int pow=0;
        while(n>0){
            int remin=n%2;
            bin=bin+remin*(int)Math.pow(10,pow);
            
            n=n/2;
            pow++;
        }
       return bin;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        //System.out.println(dectobin(n));
        System.out.println(bintodec(n));
        //System.out.println(dectobin(n));
        
    }
}
