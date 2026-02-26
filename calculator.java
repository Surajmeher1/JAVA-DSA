import java.util.*;
public class calculator {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 2 number ");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("enter the function you want to do (+,-,*,/,%)");
      char c=sc.next().charAt(0);
        switch (c) {
            case '+':
                System.out.println(a+" + "+b+" = "+(a+b));
                break;
            case'-':
            System.out.println(a+" - "+b+" = "+(a-b));
            break;
            case '*':
            System.out.println(a+" * "+b+" = "+(a*b));
            break;
            case '/':
            System.out.println(a+" / "+b+" = "+(a/b));
            break;
            case '%':
            System.out.println(a+" % "+b+" = "+(a%b));
            break;
            default:
                System.out.println("invalid action");
                break;
        }
        
      }

}
