package com.example.StudentApp.Controller;

import com.example.StudentApp.Exceptation.StudentNotFoundException;
import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Service.StudentServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Validated
public class StudentController {


    private StudentServiceImplementation studentServiceimpl;
    @Autowired
    public StudentController(StudentServiceImplementation studentService) {
        this.studentServiceimpl = studentService;
    }

    @PostMapping("/student")
    ResponseEntity<?>saveStudent(@Valid @RequestBody Student student)
    {
         return new ResponseEntity<>(studentServiceimpl.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping("/students")
    ResponseEntity<?>getAllStudents()
    {
        return new ResponseEntity<>(studentServiceimpl.getAllStudents(),HttpStatus.FOUND);
    }

    @GetMapping("/student/{lastName}")
    public ResponseEntity<?> getAllStudentsByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(studentServiceimpl.getStudentByLastName(lastName), HttpStatus.FOUND);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<?>getStudentsById(@PathVariable int studentId) throws StudentNotFoundException {
        return new ResponseEntity<>(studentServiceimpl.getStudentByid(studentId),HttpStatus.OK);
    }
    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable int studentId) throws StudentNotFoundException {
        return new ResponseEntity<>(studentServiceimpl.deleteStudentById(studentId), HttpStatus.OK);
    }
    @PutMapping("/student/{studentId}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable int studentId) throws StudentNotFoundException {
        return new ResponseEntity<>(studentServiceimpl.updateStudent(student,studentId), HttpStatus.OK);
    }

}
