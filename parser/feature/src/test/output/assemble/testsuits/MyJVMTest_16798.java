public class MyJVMTest_16798 {

    static Y y = null;

    Y foo(Y y) {
        X x = (X) y;
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16798().foo(y);
    }
}
