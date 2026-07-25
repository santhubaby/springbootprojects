package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Course;

public interface Courserepo extends JpaRepository<Course,Integer> {

}
