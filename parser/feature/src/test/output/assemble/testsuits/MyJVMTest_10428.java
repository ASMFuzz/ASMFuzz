public class MyJVMTest_10428 {

    void testChar() {
        final char fc = '0';
        Byte b = fc;
        Short s = fc;
        Character c = fc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10428().testChar();
    }
}
