public class MyJVMTest_17019 {

    static boolean b = true;

    boolean bar(boolean b) {
        final int i;
        assert b : i = 3;
        i = 4;
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17019().bar(b);
    }
}
