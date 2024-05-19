import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

class ClassroomTest {

    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Student student5;



    @BeforeEach
    void setUp(){

        Double[] student1Scores = {93.0, 89.0, 96.0};
        student1 = new Student("Stan", "Marsh", student1Scores);

        Double[] student2Scores = {87.0, 85.0, 92.0};
        student2 = new Student("Kyle", "Broflovski", student2Scores);

        Double[] student3Scores = {80.0, 78.0, 89.0};
        student3 = new Student("Eric", "Cartman", student3Scores);

        Double[] student4Scores = {75.0, 71.0, 80.0};
        student4 = new Student("Kenny", "McCormick", student4Scores);

        Double[] student5Scores = {64.0, 70.0, 75.0};
        student5 = new Student("Butters", "Stotch", student5Scores);
    }

    @Test
    void maxStudentsConstructorTest(){

        Classroom classroom = new Classroom(24);

        int expected = 24;

        assertEquals(expected, classroom.getStudents().length);
    }

    @Test

    void givenStudentsConstructorTest(){

        Student[] students = {student1, student2, student3, student4, student5};

        Classroom classroom = new Classroom(students);

        Student[] expected = {student1, student2, student3, student4, student5};

        assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    void nullaryConstructorTest(){

        Classroom classroom = new Classroom();

        int expected = 30;

        assertEquals(expected, classroom.getStudents().length);
    }

    @Test
    void getAverageExamScore5GivenStudentsTest(){

        Student[] students = {student1, student2, student3, student4, student5};

        Classroom classroom = new Classroom(students);

        Double expected = 81.6;

        assertEquals(expected, classroom.getAverageExamScore());

    }

    @Test
    void getAverageExamScoreNoStudentsTest(){

        Classroom classroom = new Classroom();

        Double expected = NaN;

        assertEquals(expected, classroom.getAverageExamScore());
    }

    @Test
    void addStudentNotFullTest(){

        Classroom classroom = new Classroom(2);

        classroom.addStudent(student1);

        Student[] expected = {student1, null};

        assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    void addStudentFullTest(){

        Classroom classroom = new Classroom(2);

        classroom.addStudent(student1);

        classroom.addStudent(student2);

        classroom.addStudent(student3);

        Student[] expected = {student1, student2};

        assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    void removeStudentTest(){

        Classroom classroom = new Classroom(3);

        classroom.addStudent(student2);

        classroom.addStudent(student1);

        classroom.addStudent(student3);



        classroom.removeStudent("Stan", "Marsh");
        classroom.removeStudent("Kyle", "Broflovski");

        Student[] expected = {student3, null, null};

        assertArrayEquals(expected, classroom.getStudents());
    }

    @Test
    void getStudentsByScoreNoDuplicateTest(){

        Classroom classroom = new Classroom(3);

        classroom.addStudent(student2);

        classroom.addStudent(student1);

        classroom.addStudent(student3);

        Student[] expected = {student1, student2, student3};

        assertArrayEquals(expected, classroom.getStudentsByScore());

    }

    @Test
    void getStudentsByScoreDuplicateExamsTest(){

        Classroom classroom = new Classroom(4);
        Double[] student1Scores = {93.0, 89.0, 96.0};
        student2 = new Student("Kyle", "Broflovski", student1Scores);

        classroom.addStudent(student2);
        classroom.addStudent(student1);
        classroom.addStudent(student3);

        Student[] expected = {student2, student1, student3, null};

        assertArrayEquals(expected, classroom.getStudentsByScore());

    }

    @Test
    void getGradeBookTest(){
        Student[] students = {student1, student2, student3, student4, student5};
        Classroom classroom = new Classroom(students);

        HashMap<Student,Character> gradeBook = classroom.getGradeBook();

        assertEquals('A', gradeBook.get(student1));
        assertEquals('C', gradeBook.get(student2));
        assertEquals('C', gradeBook.get(student3));
        assertEquals('D', gradeBook.get(student4));
        assertEquals('F', gradeBook.get(student5));



    }

}