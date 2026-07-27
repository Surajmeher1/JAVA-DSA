public class test1 {
    public static int arrlarg(int [] v1){
        int max = v1[0];
        for(int i=1;i<v1.length;i++){
            if(v1[i]>max){
                max = v1[i];
            }
        }
        return max;
    }
    public static int arrsmall(int [] v1){
        int min = v1[0];
        for(int i=1;i<v1.length;i++){
            if(v1[i]<min){
                min =v1[i];
            }
        }
        return min;
    }
    public static int arrsum(int [] v1 ){
        int sum =0;
        for( int i=0;i<v1.length;i++){
            sum+=v1[i];
        }
        return sum;
    }
    public static double arravg(int [] v1){
        double to=arrsum(v1);

        double avg=(to/v1.length);
        return avg;
    }
    public static void evod(int [] v1){
        int odd=0;
        int even =0;
        for( int i=0;i<v1.length;i++){
            if(v1[i]%2==0){
                even++;
            }else
                odd++;
        }
      System.out.println("odd="+odd);
      System.out.println("even="+even);
    }
    public static void search(int[]v1,int trg){
       
        for( int i=0;i<v1.length;i++){
                    if(trg==v1[i]){
                        System.out.println("The target element store at index "+i+"th the element is "+v1[i]);
                    }
        }
        
        
    }
    public static void rev(int[]v1){
        
    }
    public static int fact(int n){
        int factr=1;
        for(int i=0;n>i;i++){
            
            factr=factr*(n-i);
            
        }
        return factr;
    }
    public static int bincoff(int n,int r){
        int down=fact(r)*fact(n-r);
        int c=fact(n)/down;
        return c;
    }
public static void hollowrectngle(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i==1||j==1||i==n||j==n){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }

        }
        System.out.println();
    }
    
}
public static void invertedandrotatedhalfpyramid(int n){
    //outerloop
    for(int i=1;i<=n;i++){
        //spaceloop
        for(int j=n;j>=i;j--){
            System.out.print(" ");
        }
        //starloop
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
}
 
public static void pyramidnumber(int n){
    //outerloop
    int count=1;
    for(int i=1;i<=n;i++){
        //spaceloop
        for(int j=n;j>=i;j--){
            System.out.print(count+" ");
            count++;
        }
        System.out.println();
        //  count=1;
    }
}
public static void floyds_triangle(int n){
    
    int count=1;

    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print(" " +count);
            count++;
        }
        
        System.out.println();
    }
}

    public static void hollowrhombus(int n){
        for(int i=1;i<=n;i++){
        for(int j=1;j<=(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=n;j++){
            if(i==1||i==n||j==1||j==n){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
            
        }
        System.out.println();
    }
}
 public static void triangle_0_1(int n) {
     for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            if(j%2!=0){
                System.out.print(" 0");
            }
            else{
                System.out.print(" 1");
            }
            
        }
        System.out.println();
    }
    
}
public static void butterfly(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        for(int j=1;j<=2*(n-i);j++){
            System.out.print(" ");
        }
        // for(int j=n-1;j>=i;j--){
        //     System.out.print(" ");
        // }
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }

        System.out.println();
    }
    for(int i=n;i>=1;i--){
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }
        // for(int j=n-1;j>=i;j--){
        //     System.out.print(" ");
        // }
        for(int j=1;j<=2*(n-i);j++){
            System.out.print(" ");
        }
        for(int j=1;j<=i;j++){
            System.out.print("*");
        }

        System.out.println();
    }
    
    
}
public static void solidrhombus(int n) {
    for(int i=1;i<=n;i++){
        for(int j=n;j>=i+1;j--){
            System.out.print(" ");
        }
        for(int j=0;j<n;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    
}
       public static void main(String[] args) {
        int n=5;
      solidrhombus(n);
        
    }
}
