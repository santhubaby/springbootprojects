package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.dao.Iuserdao;

@Service
public class Userservice {
	
        @Autowired
		private Iuserdao userDao;

		public void printName() {
			
			System.out.println(userDao.getClass());
			System.out.println(userDao.getClass().getName());
			System.out.println("userDao Obj :: " + userDao);
			String name = userDao.getName(100);
			System.out.println("Name :: " + name);
		}
	}

