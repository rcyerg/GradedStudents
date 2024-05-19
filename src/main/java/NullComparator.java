import java.util.Comparator;

public class NullComparator implements Comparator<Student> { //Tested
    @Override
    public int compare(Student o2, Student o1) { //descending order (y compare to x)
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        }
            return 1;
    }
}
