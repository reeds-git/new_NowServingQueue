package com.cs371_HCI.nowServingQueue.daoDatabase;

import com.cs371_HCI.nowServingQueue.entity.Student;

import java.util.Collection;

public interface StudentDaoInterface {

    // GET
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    // PUT
    Student updateStudent(Student student);

    Student updateStudentById(int id, Student student);

    // POST

    Student addStudent(Student student);
    // DELETE
    String removeStudentById(int id);

    // helper function
   // void updateStudentsTimes();
}
