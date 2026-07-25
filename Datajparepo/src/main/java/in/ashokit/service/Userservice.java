package in.ashokit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ashokit.entity.User;
import in.ashokit.repo.Userrepo;

@Service
public class Userservice {

	@Autowired
	public Userrepo userRepo;

	@Transactional(rollbackFor = IOException.class)
	public void saveUsers() throws Exception {

		User u1 = new User();
		u1.setName("John");
		u1.setGender("Male");
		u1.setCountry("India");
		u1.setAge(20);

		userRepo.save(u1);

	/***	int i = 10;

		if (i > 1) {
			throw new IOException("File Issue");
		}***/

		User u2 = new User();
		u2.setName("smitha");
		u2.setGender("Female");
		u2.setCountry("India");
		u2.setAge(21);

		userRepo.save(u2);

	}

	public void getUserswithSort() {

		Sort sort = Sort.by("age", "gender").descending();

		List<User> users = userRepo.findAll(sort);

		users.forEach(System.out::println);

	}

	public void getUserswithPagination() {

		Integer pageNum = 2; // we will get from UI
		Integer pageSize = 3; // it is fixed

		PageRequest pageReq = PageRequest.of(pageNum - 1, pageSize);

		Page<User> page = userRepo.findAll(pageReq);

		List<User> users = page.getContent();

		users.forEach(System.out::println);

	}

	public void qbe() {

		User user = new User();
		user.setGender("Male");
		user.setCountry("India");

		Example<User> of = Example.of(user);
		List<User> usersList = userRepo.findAll(of);

		usersList.forEach(System.out::println);
	}
}