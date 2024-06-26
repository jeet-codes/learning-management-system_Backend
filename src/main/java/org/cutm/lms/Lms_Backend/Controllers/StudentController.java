package org.cutm.lms.Lms_Backend.Controllers;


import org.cutm.lms.Lms_Backend.Entity.Student;
import org.cutm.lms.Lms_Backend.Service.StudentMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cutm/student")
@CrossOrigin("*")

public class StudentController {
    @Autowired
    private StudentMethods studentMethods;
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student student1 = studentMethods.createStudent(student);
        return  new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findbyid(@PathVariable String id) {
        Student student = studentMethods.getStudent(id);
        return  new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public List<Student> findAll(){
        List<Student> allStudent = studentMethods.getAllStudent();
        return allStudent;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        studentMethods.deleteStudent(id);
        return new ResponseEntity<>("Student having "+id+"" + "deleted Successfully", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id,@RequestBody Student student) {
        Student student1 = studentMethods.updateStudent(id, student);
        return  new ResponseEntity<>(student1, HttpStatus.ACCEPTED);
    }
}
