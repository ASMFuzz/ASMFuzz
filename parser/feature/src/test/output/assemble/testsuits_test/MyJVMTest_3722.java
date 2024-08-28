public class MyJVMTest_3722 {

    static long total = -9223372036854775808L;

    static long valid = 9223372036854775807L;

    static String op = "==[]6~gT$c";

    long testCorrectness(long total, long valid, String op) throws Exception {
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
        new MyJVMTest_3722().testCorrectness(total, valid, op);
    }
}
