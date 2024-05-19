public class TestMain {

    public static void main(String[] args) {

        int numberOfStudents = 5;

        System.out.println((int) Math.round(0.1 * numberOfStudents) - 1); //A

        System.out.println((int) Math.round(0.29 * numberOfStudents) - 1); //B

        System.out.println((int) Math.round(0.5 * numberOfStudents) - 1); //C

        System.out.println((int) Math.round(0.89 * numberOfStudents) - 1); //D
    }
}
