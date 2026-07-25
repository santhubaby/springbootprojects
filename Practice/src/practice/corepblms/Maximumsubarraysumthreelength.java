package practice.corepblms;

public class Maximumsubarraysumthreelength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] =new int[] {5,9,1,8,7};
		
		int windowsize=3;
		int temp=0;
		int l=0;
		int r=0;
		int maxsum=0;
		for(int i=0;i< a.length;i++)
		{
			if(l-r==windowsize)
			{
				temp=temp-a[r];
				
				r++;
				
			}
			temp=temp+a[i];
			maxsum=Math.max(maxsum, temp);
			l++;
			
			
		   
			
			
			
		}
       System.out.println(maxsum);
	
	}

}
