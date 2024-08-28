public class MyJVMTest_14574 {

    static String message = "A%+ouZG^5(";

    static boolean b = false;

    void fail(String message) {
        throw new RuntimeException(message);
    }

    static String text = "H+ c,Ie- t";

    String assertTrue(String message, boolean b) {
        if (!b)
            fail(message);
        return message;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14574().assertTrue(message, b);
    }
}
