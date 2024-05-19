import java.util.*;

public class Classroom {

    private Student[] students;

    public Classroom(int maxNumberOfStudents) { //Tested

        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) { //Tested

        this.students = students;
    }

    public Classroom() { //Tested
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() { //Tested with 5 total students and no students
        Double sum = 0.0;
        int numStudents = 0;
        for (Student student : students) {
            if(student != null) {
                sum += student.getAverageExamScore();
                numStudents++;
            }
        }
        return sum / numStudents;
    }

    public void addStudent(Student student) { //Tested
        int i = 0;
        while (i < this.students.length) {
            if (this.students[i] == null) {
                this.students[i] = student;
                break;
            }
            i++;
        }
        if (i == students.length) {
            System.out.println("ERROR: CLASS FULL!");
        }
    }

    public void removeStudent(String firstName, String lastName) { //Tested
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].getFirstName().equals(firstName) && this.students[i].getLastName().equals(lastName)) {
                this.students[i] = null;
                break;
            }
        }
        NullComparator nullComparator = new NullComparator();
        Arrays.sort(this.students, nullComparator);
    }

    public Student[] getStudentsByScore() { //Tested

        Student[] copyArray;

        copyArray = this.students.clone();

        GradeComparator gradeComparator = new GradeComparator();
        Arrays.sort(copyArray, gradeComparator);

        return copyArray;
    }


    public HashMap<Student, Character> getGradeBook() {

        Character character;
        HashMap<Student, Character> gradeBook = new HashMap<>();

        Student[] copyArray;
        copyArray = this.students.clone();
        int numberOfStudents = 0;

        for (Student s : copyArray) {
            if (s != null) {
                numberOfStudents++;
            }
        }

        GradeComparator gradeComparator = new GradeComparator();
        Arrays.sort(copyArray, gradeComparator);

        for (Student s : this.students) {
            if (s == null){
                break;
            }
            //n (total number of values) = numberOfStudents;
            //upper 10th - score >= (10/100 * n) --> > round .getAverageExamScore()
            if (s.getAverageExamScore() >= this.students[(int) Math.round(0.1 * numberOfStudents) - 1 ].getAverageExamScore()) {
                character = 'A';
            } else if (s.getAverageExamScore() >= this.students[(int) Math.round(0.29 * numberOfStudents) - 1].getAverageExamScore()) {
                character = 'B';
            } else if (s.getAverageExamScore() >= this.students[(int) Math.round(0.50 * numberOfStudents) - 1].getAverageExamScore()) {
                character = 'C';
            } else if (s.getAverageExamScore() >= this.students[(int) Math.round(0.89 * numberOfStudents) - 1].getAverageExamScore()) {
                character = 'D';
            } else {
                character = 'F';
            }

            gradeBook.put(s, character);
        }

        return gradeBook;

    }


}
