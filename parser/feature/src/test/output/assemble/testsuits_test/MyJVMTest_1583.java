public class MyJVMTest_1583 {

    static A other = null;

    static A saved = null;

    A check(A other) {
        if (this.saved != other) {
            throw new RuntimeException("TEST FAILED: Objects not equal.");
        }
        return other;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1583().check(other);
    }
}
