import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NullComparatorTest {


    private Student student1;
    private Student student2;
    private Student student3;

    private NullComparator nullComparator;

    @BeforeEach
    void setUp() {

        Double[] student1Scores = {93.0, 89.0, 96.0};
        student1 = new Student("Stan", "Marsh", student1Scores);

        Double[] student2Scores = {87.0, 85.0, 92.0};
        student2 = new Student("Kyle", "Broflovski", student2Scores);

        Double[] student3Scores = {80.0, 78.0, 89.0};
        student3 = new Student("Eric", "Cartman", student3Scores);

        nullComparator = new NullComparator();
    }

    @Test
    void nullComparatorTest(){
        Student[] students = {student1, null, student2, null};

        Arrays.sort(students, nullComparator);

        assertEquals(null, students[2]);

        assertEquals(null, students[3]);
    }
}