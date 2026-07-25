package practice.corepblms;
public class Sortedornot

{
    public static boolean sortedornot(int[] arr, int i)
    {  
        if(i==arr.length-1)
        {
            return true;
        }
    
        return arr[i]<arr[i+1] && sortedornot(arr,i+1);
        
        
        
    }
	 public static void main (String[] args) {
	  
	
	    int[ ] arr={1,4,9,45};
		System.out.println(sortedornot(arr,0));
	}
}
