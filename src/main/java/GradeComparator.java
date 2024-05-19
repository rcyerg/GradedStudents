import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {

    /* x.compareTo(y):
    * negative value: if x < y
    * zero if x == y
    * positive value: if x > y
     */

    @Override
    public int compare(Student o2, Student o1) { //descending order y compare to x
        if (o1 == null || o2 == null) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (o2.getAverageExamScore() == o1.getAverageExamScore()) {
                return o2.getFirstName().compareTo(o1.getFirstName());
            }
            if (o1.getAverageExamScore() > o2.getAverageExamScore()) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}

