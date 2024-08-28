public class MyJVMTest_16360 {

    static String problem = "cCvBhKk:!3";

    static boolean counterrors = true;

    static int errcount = 0;

    String error(String problem) {
        if (counterrors) {
            errcount++;
        } else {
            throw new RuntimeException(problem);
        }
        return problem;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16360().error(problem);
    }
}
