public class MyJVMTest_15392 {

    static int found = 0;

    static int req = 0;

    static X x = null;

    int equals(int found, int req) {
        if (found != req) {
            throw new AssertionError("Error (expected: " + req + " - found: " + found + ")");
        }
        return req;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15392().equals(found, req);
    }
}
