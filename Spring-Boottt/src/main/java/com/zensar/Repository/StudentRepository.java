package com.zensar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query("from Student s where  s.studId=?1 or s.studAge=?2")
	List<Student> repoQuery1(int studId, int studAge);

	// List<Student> getByStudName(String studName);
	// List<Student> findByStudName(String studName);
	// List<Student> findByStudNameAndStudAge(String studName,int studAge);
	List<Student> test(String studName);

	List<Student> test1(String studName, int studAge);

	List<Student> test3(String studName, int studId);

	@Query("from Student s where s.studName=:name and s.studAge=:age")
	List<Student> testt(@Param("name") String studName, @Param("age") int age);
}
