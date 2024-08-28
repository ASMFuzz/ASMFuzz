public class MyJVMTest_17205 {

    static int total = -627795327;

    static int valid = 6505971;

    static String op = "j\"4Wh%P+SG";

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
        new MyJVMTest_17205().testCorrectness(total, valid, op);
    }
}
