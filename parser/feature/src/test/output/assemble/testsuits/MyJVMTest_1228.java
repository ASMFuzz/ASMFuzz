public class MyJVMTest_1228 {

    void testChar() {
        final char fc = '0';
        Byte b = fc;
        Short s = fc;
        Character c = fc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1228().testChar();
    }
}
