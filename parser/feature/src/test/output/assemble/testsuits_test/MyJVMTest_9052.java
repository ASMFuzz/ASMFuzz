public class MyJVMTest_9052 {

    static int exp = 4;

    static long count = 0;

    static int testState = -355633097;

    int checkTestState(int exp) {
        if (testState != exp) {
            System.err.println("Failure at " + count + " loops.");
            throw new InternalError("Unexpected test state value: " + "expected=" + exp + " actual=" + testState);
        }
        return exp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9052().checkTestState(exp);
    }
}
