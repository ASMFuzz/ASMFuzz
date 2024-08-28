public class MyJVMTest_7712 {

    static String sbParam1 = "fc;5\\2DL3#";

    static StringBuffer sb = new StringBuffer(sbParam1);

    StringBuffer doWith(StringBuffer sb) {
        "AA".contentEquals(sb);
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7712().doWith(sb);
    }
}
