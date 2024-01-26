package com.example.StudentApp.Repository;

import com.example.StudentApp.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
List<Student>findByLastName(String lastname);



}
