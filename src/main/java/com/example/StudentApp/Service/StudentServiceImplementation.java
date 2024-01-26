package com.example.StudentApp.Service;

import com.example.StudentApp.Exceptation.StudentNotFoundException;
import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImplementation implements StudentServiceInterface {


    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, int student_id) throws StudentNotFoundException{
        Optional<Student> optUser = studentRepository.findById(student_id);
        if (optUser.isEmpty())
        {
            throw new StudentNotFoundException("Student Not found");
        }
        Student existingUser = optUser.get();
        System.out.println(existingUser);

        if (student.getFirstName() != null) {
            existingUser.setFirstName(student.getFirstName());
        }
        if (student.getLastName()!= null) {
            existingUser.setLastName(student.getLastName());
        }
        if (student.getEmail() != null) {
            existingUser.setEmail(student.getEmail());
        }
        if (student.getPhoneNumber() != 0){
            existingUser.setPhoneNumber(student.getPhoneNumber());
        }
        if (student.getAddress()!= null) {
            existingUser.setAddress(student.getAddress());
        }
        if (student.getStandard()!= 0){
            existingUser.setStandard(student.getStandard());
        }

        return studentRepository.save(existingUser);

    }

    @Override
    public String deleteStudentById(int student_id) throws StudentNotFoundException {
        if (studentRepository.findById(student_id).isEmpty())
        {
          throw new StudentNotFoundException("student is not Present");
        }else
        {
            studentRepository.deleteById(student_id);
            return "Student deleted Successfully";
        }
    }

    @Override
    public List<Student> getStudentByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public Student getStudentByid(int studentId) throws StudentNotFoundException {
        Optional<Student> student=studentRepository.findById(studentId);
        Student exist=student.get();
        if (student.isEmpty())
        {
            throw new StudentNotFoundException("Student not found with given student_id :"+studentId);
        }else
            return exist;
    }
}
