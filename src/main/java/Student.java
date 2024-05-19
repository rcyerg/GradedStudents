import java.util.*;
public class Student {

    private String firstName;

    private String lastName;

    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) { //Tested
        examScores = new ArrayList<>(Arrays.asList(testScores));
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() { //Tested
        return this.examScores.size();
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public String getFormattedExamScores() { //Tested

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Exam Scores:\n");
        int examNumForString = 1;
        for (Double score : this.examScores) {
            stringBuilder.append("\tExam ").append(examNumForString).append(" -> ").append(score).append("\n");
            examNumForString++;
        }
        return stringBuilder.toString();
    }

    public void addExamScore(Double examScore) { //Tested
        examScores.add(examScore);
    }
    public void setExamScore(int examNumber, Double newScore) { //Tested
        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore() { //Tested
        double sum = 0;
        for (Double score : this.examScores) {
            sum += score;
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[Student Name: ").append(firstName).append(" ").append(lastName).append("\n");
        stringBuilder.append("> Average Score: ").append(this.getAverageExamScore()).append("\n");
        stringBuilder.append("> Exam Scores:\n");
        int examNumForString = 1;
        for (Double score : this.examScores) {
            stringBuilder.append("    Exam " + examNumForString + " -> " + score + "\n");
            examNumForString++;

        }
        String string2 = stringBuilder.toString().trim();
        string2 = string2.concat("]\n");
        return string2;
    }

}
