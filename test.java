import java.util.*;
public class test {
    public static int product(int a,int b ){
        int pro=a*b;
        return pro;
    }
    public static int fact(int n){
        int nt=1;
        for(int i=1;i<=n;i++){
            nt=nt*i;
        }
        return nt;
    }
    public static double bincoff(int n,int r){
       double half=fact(r)*fact(n-r);
        double c=fact(n)/half;
    return c;
    }
    public static int b(int a,int b){
        return a+b;
    }
    public static int b(float a,float b){
        return (int) (a*b);
    } 
    public static boolean prime(int n){
     if(n==2){
        return true;
     }
        for(int i=2;i<=n-1;i++){
            if (n%i==0) {
                return false;
            }
        }
        return true;
        
    }
    public static int bintodec (int n){
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number ");
        int a=sc.nextInt();

}
}