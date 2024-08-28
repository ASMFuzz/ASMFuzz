public class MyJVMTest_10804 {

    static A other = null;

    static A saved = null;

    A check(A other) {
        if (this.saved != other) {
            throw new RuntimeException("TEST FAILED: Objects not equal.");
        }
        return other;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10804().check(other);
    }
}
