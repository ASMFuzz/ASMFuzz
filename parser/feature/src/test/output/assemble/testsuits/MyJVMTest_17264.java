public class MyJVMTest_17264 {

    static CharSequence sbParam1 = null;

    static StringBuffer sb = new StringBuffer(sbParam1);

    StringBuffer doWith(StringBuffer sb) {
        "AA".contentEquals(sb);
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17264().doWith(sb);
    }
}
