public class MyJVMTest_15934 {

    static int exp = 1448036641;

    static long count = 0;

    static int testState = 0;

    int checkTestState(int exp) {
        if (testState != exp) {
            System.err.println("Failure at " + count + " loops.");
            throw new InternalError("Unexpected test state value: " + "expected=" + exp + " actual=" + testState);
        }
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15934().checkTestState(exp);
    }
}
