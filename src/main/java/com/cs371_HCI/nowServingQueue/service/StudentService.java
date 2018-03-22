package com.cs371_HCI.nowServingQueue.service;

import com.cs371_HCI.nowServingQueue.daoDatabase.StudentDaoTempData;
import com.cs371_HCI.nowServingQueue.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    @Qualifier("tempData")
    private StudentDaoTempData studentDaoTempData;

    // GET
    public Collection<Student> getAllStudents() {
        return this.studentDaoTempData.getAllStudents();
    }

    public Student getStudentById(int id) {
        return this.studentDaoTempData.getStudentById(id);
    }

    // PUT
    public Student updateStudent(Student student) {
        return this.studentDaoTempData.updateStudent(student);
    }

    public Student updateStudentById(int id, Student student) {
        return this.studentDaoTempData.updateStudentById(id, student);
    }

    // POST
    public Student addStudent(Student student) {
        return this.studentDaoTempData.addStudent(student);
    }

    //DELETE
    public String removeStudentById(int id) {
        return this.studentDaoTempData.removeStudentById(id);
    }

    public String removeAllStudents() {
        return this.studentDaoTempData.removeAllStudents();
    }

    public String resetStudents() {
        return this.studentDaoTempData.resetStudents();
    }
}
