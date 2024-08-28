public class MyJVMTest_6855 {

    static String problem = "s%+bfmb3IQ";

    static boolean counterrors = false;

    static int errcount = 1;

    String error(String problem) {
        if (counterrors) {
            errcount++;
        } else {
            throw new RuntimeException(problem);
        }
        return problem;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6855().error(problem);
    }
}
