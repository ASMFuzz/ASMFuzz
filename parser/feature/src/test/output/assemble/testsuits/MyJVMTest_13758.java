public class MyJVMTest_13758 {

    static Y y1 = null;

    static X x2 = null;

    X m(Y y1, X x2) {
        throw new Error("A.m(Y,X) should not be called");
        return x2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13758().m(y1, x2);
    }
}
