package com.cs371_HCI.nowServingQueue.daoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cs371_HCI.nowServingQueue.entity.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
@Qualifier("tempData")
public class StudentDaoTempData implements StudentDaoInterface {

    @Autowired
    private static Map<Integer, Student> students;

    private static int nextAvailableID = 1;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(0, new Student(0,
                        "Billy Sue", "CS 124", true));
            }
        };
    }

    // GET
    @Override
    public Collection<Student> getAllStudents() {
       // updateStudentsTimes();
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    // PUT
    @Override
    public Student updateStudent(Student student) {

        Student currentStudent = this.students.get(student.getId());

        if (student.getName() != null) {
            currentStudent.setName(student.getName());
        }

        if (student.getCourse() != null) {
            currentStudent.setCourse(student.getCourse());
        }

//        if (student.getStartTime() != null) {
//            currentStudent.setTimeOnQueue();
//        }

        if (student.getReceivedHelp() != null) {
            currentStudent.setReceivedHelp(student.getReceivedHelp());
        }

        this.students.put(currentStudent.getId(), currentStudent);

        return currentStudent;
    }

    @Override
    public Student updateStudentById(int id, Student student) {

        if (this.students.containsKey(id)) {

            Student currentStudent = this.students.get(id);

            if (student.getName() != null) {
                currentStudent.setName(student.getName());
            }

            if (student.getCourse() != null) {
                currentStudent.setCourse(student.getCourse());
            }
//            if (student.getStartTime() != null) {
//                currentStudent.setTimeOnQueue();
//            }

            if (student.getReceivedHelp() != null) {
                currentStudent.setReceivedHelp(student.getReceivedHelp());
            }

            this.students.put(currentStudent.getId(), currentStudent);

            return currentStudent;
        }

        return student;
    }

    // POST
    @Override
    public Student addStudent(Student student) {

        Student newStudent = new Student();

        newStudent.setId(nextAvailableID++);
        newStudent.setName(student.getName());
        newStudent.setCourse(student.getCourse());
        newStudent.setReceivedHelp(false);

        students.put(newStudent.getId(), newStudent);

        return newStudent;
    }

    // DELETE
    @Override
    public String removeStudentById(int id) {

        if (this.students.containsKey(id)) {
            this.students.remove(id);

            return "Student " + id + " was removed";
        } else {
            return "There is no student with the id of " + id + ".";
        }
    }

    public String removeAllStudents() {

        this.students.clear();

        nextAvailableID = 1;
        return "All students removed.";
    }

    public String resetStudents() {

        this.students.clear();
        this.students.put(0, new Student(0,
                "Billy Sue", "CS 124", true));
        nextAvailableID = 1;
        return "Students reset.";
    }

//    // Helper Function
//    @Override
//    public void updateStudentsTimes() {
//        Iterator iterator = students.keySet().iterator();
//        Integer key = 0;
//        Student currentStudent;
//
//        while (iterator.hasNext()) {
//            key = (Integer)iterator.next();
//            currentStudent = students.get(key);
//            System.out.println("ID = " + currentStudent.getId());
//            currentStudent.setTimeOnQueue();
//        }
//    }
}
