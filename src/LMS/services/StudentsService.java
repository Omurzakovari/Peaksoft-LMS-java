package LMS.services;

import LMS.user.Students;

import java.util.List;

public interface StudentsService {
    void addStudent (Students student);
    Students getStudentById(Long id);
    void updateStudent (Long id, Students student);
    List<Students>  getAllStudents();
    void deleteStudent(Long id);

}
