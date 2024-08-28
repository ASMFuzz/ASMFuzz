public class MyJVMTest_7482 {

    static boolean b = false;

    boolean bar(boolean b) {
        final int i;
        assert b : i = 3;
        i = 4;
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7482().bar(b);
    }
}
