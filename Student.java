import java.util.ArrayList;
import java.util.List;

public class Student {
    String student_name;
    List<Course> courses = new ArrayList<Course>();

    public Student(String student_name) {
        this.student_name = student_name;
    }

    public void addCourse(Course c) {
        this.courses.add(c);
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    @Override
    public String toString() {
        return student_name;
    }
}
