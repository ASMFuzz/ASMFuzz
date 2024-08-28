public class MyJVMTest_7274 {

    static Y y = null;

    Y foo(Y y) {
        X x = (X) y;
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7274().foo(y);
    }
}
