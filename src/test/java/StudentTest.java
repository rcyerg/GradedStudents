import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

  private Student student1;


  @BeforeEach //comment out before studentConstructorTest
  void setUp(){
    Double[] student1TestScores = {80.0, 84.0, 96.0, 86.0, 90.0};
    student1 = new Student("Tom", "Smith", student1TestScores);
  }


  @Test
  void studentConstructorTest(){

    Double[] student1TestScores = {80.0, 84.0, 96.0, 86.0, 90.0};
    student1 = new Student("Tom", "Smith", student1TestScores);


    String expected = "Tom";
    assertEquals(expected, student1.getFirstName());

    expected = "Smith";
    assertEquals(expected, student1.getLastName());

    ArrayList<Double> expectedScores = new ArrayList<>(Arrays.asList(student1TestScores));

    assertEquals(expectedScores, student1.getExamScores());
  }

  @Test
  void getNumberOfExamsTest(){

    int expected = 5;

    assertEquals(expected, student1.getNumberOfExamsTaken());
  }

  @Test
  void getFormattedExamScoresTest(){

    String expected = "Exam Scores:\n\tExam 1 -> 80.0\n\tExam 2 -> 84.0\n\tExam 3 -> 96.0\n\tExam 4 -> 86.0\n\tExam 5 -> 90.0\n";

    assertEquals(expected, student1.getFormattedExamScores());
  }

  @Test
  void addExamScoreTest(){

    student1.addExamScore(89.0);

    ArrayList<Double> expected = new ArrayList<>(Arrays.asList(80.0, 84.0, 96.0, 86.0, 90.0, 89.0));

    assertEquals(expected, student1.getExamScores());
  }

  @Test
  void setExamScoreTest(){

    student1.setExamScore(1, 81.0);

    ArrayList<Double> expected = new ArrayList<>(Arrays.asList(81.0, 84.0, 96.0, 86.0, 90.0));

    assertEquals(expected, student1.getExamScores());
  }

  @Test
  void getAverageExamScoreTest(){

    Double expected = 87.2;

    assertEquals(expected, student1.getAverageExamScore());
  }
}