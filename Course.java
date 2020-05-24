import java.util.ArrayList;
import java.util.List;

public class Course {
    String course_name;
    List<Student> students = new ArrayList<>();
    Lecturer lecturer;

    public Course(String course_name) {
        this.course_name = course_name;
    }

    public void addStudent(Student s) {
        this.students.add(s);
        s.addCourse(this);
    }

    public void addLecturer(Lecturer l){
        this.lecturer = l;
        l.addCourse(this);
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public Lecturer getLecturer(){
        return this.lecturer;
    }

    @Override
    public String toString() {
        String studentsString = "";

        for (Student s : students)
        {
            studentsString += s + "\n";
        }

        String res = "Курс" + "\n" +
                course_name + "\n" + "\n" +
                "Преподаватель" + "\n" +
                lecturer + "\n" + "\n" +
                "Студенты" + "\n" +
                studentsString
                ;
        return res;
    }
}
