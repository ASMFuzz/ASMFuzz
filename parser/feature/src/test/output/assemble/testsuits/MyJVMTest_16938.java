public class MyJVMTest_16938 {

    static X x1 = null;

    static X x2 = null;

    X m(X x1, X x2) {
        throw new Error("B.m(X,X) should not be called");
        return x2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16938().m(x1, x2);
    }
}
