package practice.corepblms;
public class Binarysearchrecursion
{
    
    public static int binarysearch(int[] arr,int start, int end,int target)
    {
        
          if(start<=end){
            int mid= (start+end)/2;
            if(target==arr[mid])
            {
                return mid;
            }
            
            if(target<arr[mid]){
                
                return binarysearch(arr,start,mid-1,target);
            }
            if(target>arr[mid]){
                
                return binarysearch(arr,mid+1,arr.length-1,target);
            }
          }
            
           return -1;
        
    }
	public static void main(String[] args) {
	    
	    int[] arr={2,3,4,5,6};
		System.out.println(binarysearch(arr,0,arr.length-1,9));
	}
}
