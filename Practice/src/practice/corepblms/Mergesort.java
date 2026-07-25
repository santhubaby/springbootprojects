package practice.corepblms;
import java.util.*;
public class Mergesort


{  
    public static int[] mergesort(int[] arr)
    {
        if(arr.length==1)
        {
            return arr;
        }
        int mid=arr.length/2;
        int[] first= mergesort(Arrays.copyOfRange(arr,0,mid));
        
        int[] second= mergesort(Arrays.copyOfRange(arr,mid,arr.length));
        
        return merge(first,second);

    }
    
    public static int[] merge(int[] a,int[] b)
    {
        int[] mix =new int[a.length+b.length];
        
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<b[j])
            {
                mix[k]=a[i];
                i++;
                
            }
            else{
            mix[k]=b[j];
            j++;}
            
            k++;
            
        }
        while(i<a.length)
        {
            mix[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length)
        {
            mix[k]=b[j];
            j++;
            k++;
        }
        
        return mix;
    }
   
	public static void main(String[] args) {
	    
	    int[] arr={5,6,8,2,3,1,4,};
	    System.out.println(Arrays.toString(mergesort(arr)));
	    
	    
	}
}
