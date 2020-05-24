import java.util.ArrayList;
import java.util.List;

public class Lecturer {
    String lecturer_name;
    List<Course> courses = new ArrayList<Course>();

    public Lecturer(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public void addCourse(Course c) {
        this.courses.add(c);
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    @Override
    public String toString() {
        return lecturer_name;
    }
}
