public class MyJVMTest_13535 {

    static boolean okay = true;

    static boolean failed = false;

    boolean check(boolean okay) {
        if (!okay) {
            failed = true;
        }
        return okay;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13535().check(okay);
    }
}
