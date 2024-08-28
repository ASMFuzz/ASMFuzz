public class MyJVMTest_13060 {

    static long total = -7923035437133639898L;

    static long valid = 484934133939349922L;

    static String op = "G<bX.5XL6D";

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
        new MyJVMTest_13060().testCorrectness(total, valid, op);
    }
}
