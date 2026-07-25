package in.ashokit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Userdaoimpl implements Iuserdao {
	

		public Userdaoimpl() {
			System.out.println("UserDaoImpl :: Constructor");
		}
      
		
		@Override
		public String getNamesanthu(String s) {
			return s;
		}
		
		@Override
		public String getName(int id)
		
		{   
			System.out.println(this.getNamesanthu("santhu"));
		
			return "John";
		}
	}


