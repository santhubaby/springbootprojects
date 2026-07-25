package in.ashokit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Userdao {

		public Userdao() {
			System.out.println("UserDao :: Constructor");
		}

		public String getNameById(int id) {
			if (id == 100) {
				return "John";
			} else {
				return "Smith";
			}
		}
	}

