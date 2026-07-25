package practice.corepblms;

public class Binarysearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[] {2,4,6,7,8,9};
		int l=0;
		int r=a.length;;
		
		int target=6;
		while(l<=r)
		{   
			int mid= (l+r)/2;
			if(a[mid]==target)
				{
				System.out.println("found position:"+mid);
				 break;
				}
			if(a[mid]<target)   
			{
				l=mid+1;
			}
			if(a[mid]>target)
			{
				r=mid-1;
			}
			    
		}
		
		

	}

}
