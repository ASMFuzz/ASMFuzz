public class MyJVMTest_7656 {

    static int total = 0;

    static int valid = 3;

    static String op = "a*<%d;!@Eb";

    int testCorrectness(int total, int valid, String op) throws Exception {
        if (total == valid) {
            System.out.println(op + ": Success");
        } else {
            System.out.println("Invalid total: " + total);
            System.out.println("Expected value = " + valid);
            throw new Exception(op + ": Failed");
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7656().testCorrectness(total, valid, op);
    }
}
