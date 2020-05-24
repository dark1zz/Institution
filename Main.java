import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static Institution createSampleInstitute(){
        Institution institution = new Institution("Институт 123", "г. Город");

        institution.addCourse(new Course("Физика"));
        institution.addCourse(new Course("Информатика"));
        institution.addCourse(new Course("Математика"));

        institution.addLecturer(new Lecturer("Физик"));
        institution.addLecturer(new Lecturer("Информатик"));
        institution.addLecturer(new Lecturer("Математик"));

        institution.addStudent(new Student("Иванов Иван Иванович"));
        institution.addStudent(new Student("Петров Перт Петрович"));
        institution.addStudent(new Student("Сидоров Сидр Сидорович"));

        for(int i = 0; i < 3; i++) {
            Lecturer l = institution.getLecturer(i);
            Course course = institution.getCourse(i);
            Student s = institution.getStudent(i);
            Student s2 = institution.getStudent((i + 1)% 3);
            course.addLecturer(l);
            course.addStudent(s);
            course.addStudent(s2);
        }
        return institution;
    };

    public static Institution parseInstituteFromString(String stringedInstitute){
        String[] lines = stringedInstitute.split("\\r?\\n");

        boolean iname = false, ic = false, stds = false, lctrs = false, crss = false, pcrs = false, plctr = false, pstds = false;
        Course curCrs = null;
        String iName = null;
        String city = null;
        Institution institution = null;

        for (String line : lines){
            if (line.equals("Институт")) {
                iname = true; continue;
            }

            if (iname) {
                iName = line;
                iname = false;
            }

            if (line.equals("Город")) {
                ic = true; continue;
            }

            if (ic) {
                city = line;
                institution = new Institution(iName, city);
                ic = false; continue;
            }

            if (line.equals("Все Студенты")) {
                stds = true; continue;
            }

            if (stds) {
                if (line.length() < 3){
                    stds = false;
                }
                institution.addStudent(new Student(line)); continue;
            }

            if (line.equals("Все Преподаватели")) {
                lctrs = true; continue;
            }

            if (lctrs) {
                if (line.length() < 3){
                    lctrs = false;
                }
                institution.addLecturer(new Lecturer(line)); continue;
            }

            if (line.equals("Все Курсы")) {
                crss = true; continue;
            }

            if (crss) {
                if (line.length() < 3){
                    crss = false; continue;
                }
                institution.addCourse(new Course(line)); continue;
            }

            if (line.equals("Курс")) {
                pcrs = true; curCrs = null; continue;
            }

            if (pcrs) {
                if (line.length() < 3){
                    if (pstds) pstds = false;
                    continue;
                }

                if (curCrs == null){
                    curCrs = institution.getCourse(line); continue;
                }

                if (line.equals("Преподаватель")) {
                    plctr = true; continue;
                }

                if (plctr){
                    curCrs.addLecturer(institution.getLecturer(line)); plctr = false; continue;
                }

                if (line.equals("Студенты")) {
                    pstds = true; continue;
                }

                if (pstds){
                    curCrs.addStudent(institution.getStudent(line)); continue;
                }
            }

        };

        return institution;
    };

    public static void outputToFile(String filename, Institution inst){
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            writer.write(inst.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String inputFromFile(String filename){
        String content = null;

        try {
            content = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static void main(String[] args) {
        //Institution institution = createSampleInstitute();
        //outputToFile("output.txt", institution);
        String input = inputFromFile("output.txt");
        Institution i = parseInstituteFromString(input);
        System.out.println(i);
    }
}
