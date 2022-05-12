package com.cts.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.hrms.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	@Query("select s from Student s where s.lastName=:ln")
	public List<Student> findStudentsByLastName(@Param("ln")String lastName);
}
