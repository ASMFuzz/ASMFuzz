public class MyJVMTest_11230 {

    static int expected = 4;

    static int real = 0;

    int assertEquals(int expected, int real) throws Exception {
        if (expected != real) {
            throw new Exception("Expected events: " + expected + " Received Events: " + real);
        }
        return real;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11230().assertEquals(expected, real);
    }
}
