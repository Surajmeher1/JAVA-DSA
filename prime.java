import java.util.*;
public class prime {
    public static boolean isprime(int n){
        
    if(n==2){
        return true;
    }
    for(int i=2;i<=Math.sqrt(n);i++){
        if(n%i==0){
            return false;
        }
        
    }
    return true;
}
public static void rangeinprime(int n){
int cont=1;
        for(int i = 2;i<=n;i++){
            if (isprime(i)==true) {
                System.out.println(cont+".it is prime number "+i);
                cont++;
            }else{ 
                continue;
            }
        }
}
public static boolean twinprimeno(int n){

    if(isprime(n)==true&isprime(n+2)==true){
        return true;
    }
    return false;
}

    public static void main(String[] args) {
        int a=5;
        System.out.println(isprime(a));
        
    }
}
