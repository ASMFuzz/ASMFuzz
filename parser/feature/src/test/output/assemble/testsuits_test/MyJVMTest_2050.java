public class MyJVMTest_2050 {

    static Object o = 0;

    static String text = "7|90K#tciK";

    Object assertNotNull(Object o) {
        if (o == null)
            throw new AssertionError();
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2050().assertNotNull(o);
    }
}
