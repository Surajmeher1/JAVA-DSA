public class linearsearch {
    public static void search(int v [],int search){
        
        for(int i=0;i<=v.length-1;i++){
            if (v[i]==search){
                System.out.println("found");
            }
        }
    }
    public static void searchindex(int v [],int search){
        
        for(int i=0;i<=v.length-1;i++){
            if (v[i]==search){
                System.out.println("found at index "+i);
            }
        }
    }
    public static void duplicate(int v [],int search){
        int count =0;
        for(int i=0;i<=v.length-1;i++){
            if(v[i]==search){
                count++;
            }
        }
        System.out.println("the no is pesent "+count+" times");
    }
    public static void largno(int v[]){

        int max=0;
        for(int i=0;i<=v.length-1;i++){
            if(max<v[i]){
                max=v[i];
            }
        }
        System.out.println("the high score in the class marks is "+max);
    }
    public static void lowesttemp(int v[]){

        int min=v[0];
        for(int i=0;i<=v.length-1;i++){
            if(min>v[i]){
                min=v[i];
                
            }
        }
        System.out.println("Lowest Temp is "+min);
    }
    public static void idcheck(int v[],int key){
        int start=0;
        int end =v.length-1;
        while(start<end){
            int mid =(start+end)/2;
            if (mid==key){
                System.out.println("found");
            }else if(start>key){
                
            }
        }
         
    }
    public static void main(String[] args) {
        int arr1[]= {12, 15, 12, 18, 12, 20};
        int sea=12;
        lowesttemp(arr1);
        
    }
}
