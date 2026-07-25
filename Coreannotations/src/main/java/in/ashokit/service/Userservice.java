package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.Userdao;

@Service
public class Userservice {
	
	    @Autowired
		private Userdao userDao;

		public Userservice() {
			System.out.println("UserService :: Constructor");
		}

		public void getName() {
			String nameById = userDao.getNameById(100);
			System.out.println(nameById);
		}
	}


