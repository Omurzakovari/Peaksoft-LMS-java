package LMS.services;

import LMS.user.Lessons;

import java.util.List;

public interface LessonsService {
    void addLesson(Lessons lesson);
    Lessons getLessonById(Long id);
    void updateLesson( Long id , Lessons lessons);
    List<Lessons> getAllLessons();
    void deleteLesson (Long id);
}
