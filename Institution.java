import java.util.ArrayList;
import java.util.List;

public class Institution {
    String instutute;
    String city;

    List<Course> courses = new ArrayList<Course>();
    List<Lecturer> lecturers = new ArrayList<Lecturer>();
    List<Student> students = new ArrayList<>();

    public Institution(String instutute, String city) {
        this.instutute = instutute;
        this.city = city;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addLecturer(Lecturer lecturer) {
        this.lecturers.add(lecturer);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student getStudent(int i){
        return this.students.get(i);
    }

    public Student getStudent(String s){
        for(Student student : students) {
            if(student.student_name.equals(s)) {
                return student;
            }
        }
        return null;
    }

    public Lecturer getLecturer(int i){
        return this.lecturers.get(i);
    }

    public Lecturer getLecturer(String s){
        for(Lecturer lecturer : lecturers) {
            if(lecturer.lecturer_name.equals(s)) {
                return lecturer;
            }
        }
        return null;
    }

    public Course getCourse(int i){
        return this.courses.get(i);
    }

    public Course getCourse(String s){
        for(Course course : courses) {
            if(course.course_name.equals(s)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String listOfAll = "";

        listOfAll += "Все Студенты\n";

        for (Student s: students){
            listOfAll += s.student_name + '\n';
        }
        listOfAll += '\n';

        listOfAll += "Все Преподаватели\n";

        for (Lecturer l: lecturers){
            listOfAll += l.lecturer_name + '\n';
        }

        listOfAll += '\n';

        listOfAll += "Все Курсы\n";

        for (Course c: courses){
            listOfAll += c.course_name + '\n';
        }

        listOfAll += '\n';

        String coursesList = "";

        for (Course c: courses){
            coursesList += c;
            coursesList += '\n';
        }

        return "Институт" + '\n' +
                instutute + '\n' + '\n' +
                "Город" + '\n' +
                city + '\n' + '\n' +
                listOfAll + coursesList
                ;
    }
}
