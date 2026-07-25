package practice.corepblms;
public class Countmaze


{  
    public static int countroutes(int r,int c)
    {
        if( r==1 || c==1)
        {
          return 1;

        }
        
        int left= countroutes(r-1,c);
        int right=countroutes(r,c-1);
        
        return left+right;
    }
	public static void main(String[] args) {
	    
	    System.out.println(countroutes(3,3));
	    
	    
	}
}
