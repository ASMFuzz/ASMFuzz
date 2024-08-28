public class MyJVMTest_3026 {

    void testShort() {
        final short fs = 0;
        Byte b = fs;
        Short s = fs;
        Character c = fs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3026().testShort();
    }
}
