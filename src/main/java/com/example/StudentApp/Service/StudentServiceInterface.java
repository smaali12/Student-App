package com.example.StudentApp.Service;

import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Exceptation.StudentNotFoundException;

import java.util.List;

public interface StudentServiceInterface {

    Student saveStudent(Student student);
    List<Student>getAllStudents();
    Student updateStudent(Student student, int student_id)throws StudentNotFoundException;
    String deleteStudentById(int studentId) throws StudentNotFoundException;
    List<Student>getStudentByLastName(String lastName);
     Student getStudentByid(int studentId)throws StudentNotFoundException;


}
