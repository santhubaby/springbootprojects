package practice.corepblms;
public class Linearsearchrecursion
{
    public static int linearsearch(int[]  arr,int i,int target)
    {
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==target )
        {
            return i;
        }
        if(arr[i]!=target){
            
            return linearsearch(arr,i+1,target);
        }
        
        return -1;
        
    }
    
    
   
    
   public static void main(String[] args) {
	    
	    int[] arr={2,3,4,5,6};
		System.out.println(linearsearch(arr,0,2));
		

	}
}
