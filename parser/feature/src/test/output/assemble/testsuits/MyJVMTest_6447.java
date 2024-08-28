public class MyJVMTest_6447 {

    static int exp = 0;

    static long count = 0;

    static int testState = 5;

    int checkTestState(int exp) {
        if (testState != exp) {
            System.err.println("Failure at " + count + " loops.");
            throw new InternalError("Unexpected test state value: " + "expected=" + exp + " actual=" + testState);
        }
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6447().checkTestState(exp);
    }
}
