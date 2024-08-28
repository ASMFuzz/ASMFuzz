public class MyJVMTest_1667 {

    static String what = "+z-Z$o+|2O";

    static Object[] fs = { 1343434642, 6, 1920813073, 0, 0, 0, 7, 0, 6, 1134189844 };

    Object[] go(String what, Object[] fs) throws Exception {
        if (fs == null)
            throw new Exception(what + " returned null");
        System.err.println("-- " + what);
        for (int i = 0; i < fs.length; i++) System.err.println(fs[i]);
        return fs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1667().go(what, fs);
    }
}
