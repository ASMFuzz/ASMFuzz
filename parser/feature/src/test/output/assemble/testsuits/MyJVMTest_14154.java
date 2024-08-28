public class MyJVMTest_14154 {

    static int i = 0;

    String getString(int i) {
        return "A" + i + "B";
    }

    static String mySweetEscape1 = null;

    static byte[] array = {-79,9,46,31,-124,-49,76,118,45,-31};

    int test1(int i) {
        mySweetEscape1 = getString(i) + "CD";
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14154().test1(i);
    }
}
