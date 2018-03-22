package com.cs371_HCI.nowServingQueue.controller;

import com.cs371_HCI.nowServingQueue.entity.Student;
import com.cs371_HCI.nowServingQueue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET
    @RequestMapping(method = RequestMethod.GET, value = "/students")
    public Collection<Student> getAllStudents() {

        return this.studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student/{id}")
    public Student getStudentById(@PathVariable("id") int id) {

        return this.studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student updateStudent(@RequestBody Student student) {
        System.out.println("hit here ");
        return this.studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student updateStudentById(@PathVariable("id") int id, @RequestBody Student student) {

        System.out.println("No here");
        return this.studentService.updateStudentById(id, student);
    }

    // POST
    @RequestMapping(method = RequestMethod.POST, value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student student) {

        return this.studentService.addStudent(student);
    }

    // DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/student/{id}")
    public String removeStudentById(@PathVariable("id") int id) {

        return this.studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/clear")
    public String removeAllStudents() {

        return this.studentService.removeAllStudents();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reset")
    public String resetStudents() {

        return this.studentService.resetStudents();
    }
}
