package com.samyakjain.demo.rest;

import com.samyakjain.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //@PostConstruct to load the student data.. only once!
    @PostConstruct
    public void loadData(){

        theStudents=new ArrayList<>();
        Student s1=new Student("Samyak","Jain");
        Student s2=new Student("Satyam","Jha");
        Student s3=new Student("Kushal","Sharma");
        theStudents.add(s1);
        theStudents.add(s2);
        theStudents.add(s3);
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if((studentId>=theStudents.size()) || studentId<0){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }
        return theStudents.get(studentId);
    }

}
