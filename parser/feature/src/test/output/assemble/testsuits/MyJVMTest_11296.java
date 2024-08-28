public class MyJVMTest_11296 {

    static Object o = 4;

    static String text = "5M;HU\"nwE<";

    Object assertNotNull(Object o) {
        if (o == null)
            throw new AssertionError();
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11296().assertNotNull(o);
    }
}
