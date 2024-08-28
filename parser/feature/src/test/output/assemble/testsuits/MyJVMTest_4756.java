public class MyJVMTest_4756 {

    static int i = 0;

    String getString(int i) {
        return "A" + i + "B";
    }

    static String mySweetEscape1 = null;

    static byte[] array = {119,22,-6,-91,100,-43,76,-67,102,-57};

    int test1(int i) {
        mySweetEscape1 = getString(i) + "CD";
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4756().test1(i);
    }
}
