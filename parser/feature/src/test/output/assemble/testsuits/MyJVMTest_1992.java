public class MyJVMTest_1992 {

    static int expected = 3;

    static int real = 1982817569;

    int assertEquals(int expected, int real) throws Exception {
        if (expected != real) {
            throw new Exception("Expected events: " + expected + " Received Events: " + real);
        }
        return real;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1992().assertEquals(expected, real);
    }
}
