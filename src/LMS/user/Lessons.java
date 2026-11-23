package LMS.user;

public class Lessons {
    private Long id;
    private String LessonName;
    private String description;

    public Lessons(Long id, String lessonName, String description) {
        this.id = id;
        LessonName = lessonName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLessonName() {
        return LessonName;
    }

    public void setLessonName(String lessonName) {
        LessonName = lessonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "lessons{" +
                "id=" + id +
                ", LessonName='" + LessonName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
