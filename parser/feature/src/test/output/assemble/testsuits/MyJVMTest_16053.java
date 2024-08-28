public class MyJVMTest_16053 {

    static A other = null;

    static A a = null;

    static A saved = null;

    A check(A other) {
        if (this.saved != other) {
            throw new RuntimeException("TEST FAILED: Objects not equal.");
        }
        return other;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16053().check(other);
    }
}
