public class MyJVMTest_10889 {

    static String what = "xsyV0XE{!#";

    static Object[] fs = { 2, 1, 1, 3, 0, 4, 0, 1613350319, -166127963, 4 };

    Object[] go(String what, Object[] fs) throws Exception {
        if (fs == null)
            throw new Exception(what + " returned null");
        System.err.println("-- " + what);
        for (int i = 0; i < fs.length; i++) System.err.println(fs[i]);
        return fs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10889().go(what, fs);
    }
}
