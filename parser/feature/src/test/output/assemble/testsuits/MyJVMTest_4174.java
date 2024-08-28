public class MyJVMTest_4174 {

    static boolean okay = false;

    static boolean failed = false;

    boolean check(boolean okay) {
        if (!okay) {
            failed = true;
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4174().check(okay);
    }
}
