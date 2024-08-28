public class MyJVMTest_5940 {

    static int found = 4;

    static int req = 0;

    static X x = null;

    int equals(int found, int req) {
        if (found != req) {
            throw new AssertionError("Error (expected: " + req + " - found: " + found + ")");
        }
        return req;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5940().equals(found, req);
    }
}
