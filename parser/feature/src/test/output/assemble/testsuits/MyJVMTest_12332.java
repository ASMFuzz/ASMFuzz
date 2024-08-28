public class MyJVMTest_12332 {

    void testShort() {
        final short fs = 0;
        Byte b = fs;
        Short s = fs;
        Character c = fs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12332().testShort();
    }
}
