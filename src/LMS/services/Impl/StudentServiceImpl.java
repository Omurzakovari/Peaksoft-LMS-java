package LMS.services.Impl;

import LMS.services.StudentsService;
import LMS.user.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentsService {
    private List<Students> students = new ArrayList<>();

    @Override
    public void addStudent(Students student) {
        students.add(student);
        System.out.println("Студент ийгиликтүү кошулду!");
    }

    @Override
    public Students getStudentById(Long id) {
        for (Students student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateStudent(Long id, Students newStudent) {
        Students student = getStudentById(id);
        if (student != null) {
            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setEmail(newStudent.getEmail());
            student.setGender(newStudent.getGender());
            student.setPassword(newStudent.getPassword());
            System.out.println("Студент өзгөртүлдү!");
        } else {
            System.out.println("Студент табылган жок!");
        }
    }

    @Override
    public List<Students> getAllStudents() {
        return students;
    }

    @Override
    public void deleteStudent(Long id) {
        Students student = getStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Студент өчүрүлдү!");
        } else {
            System.out.println("Студент табылган жок!");
        }
    }
}