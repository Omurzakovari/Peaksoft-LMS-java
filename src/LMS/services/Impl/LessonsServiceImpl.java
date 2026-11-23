package LMS.services.Impl;

import LMS.services.LessonsService;
import LMS.user.Lessons;

import java.util.ArrayList;
import java.util.List;

public class LessonsServiceImpl implements LessonsService {
    private List<Lessons> lessons = new ArrayList<>();

    @Override
    public void addLesson(Lessons lesson) {
        lessons.add(lesson);
        System.out.println("Сабак ийгиликтүү кошулду!");
    }
    @Override
    public Lessons getLessonById(Long id) {
        for (Lessons lesson : lessons) {
            if (lesson.getId().equals(id)) {
                return lesson;
            }
        }
        return null;
    }
    @Override
    public void updateLesson(Long id, Lessons newLesson) {
        Lessons lesson = getLessonById(id);
        if (lesson != null) {
            lesson.setLessonName(newLesson.getLessonName());
            lesson.setDescription(newLesson.getDescription());
            System.out.println("Сабак өзгөртүлдү!");
        } else {
            System.out.println("Сабак табылган жок!");
        }
    }
    @Override
    public List<Lessons> getAllLessons() {
        return lessons;
    }
    @Override
    public void deleteLesson(Long id) {
        Lessons lesson = getLessonById(id);
        if (lesson != null) {
            lessons.remove(lesson);
            System.out.println("Сабак өчүрүлдү!");
        } else {
            System.out.println("Сабак табылган жок!");
        }
    }
}
