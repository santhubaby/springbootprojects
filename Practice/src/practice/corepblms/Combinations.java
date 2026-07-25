package practice.corepblms;
public class Combinations

{
    public static void pad(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        
        int digit= up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++)
        {
            char ch= (char)('a'+i);
            pad(p+ch,up.substring(1));
        }
    }
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		pad("","12");
		
	}
}
