public class MyJVMTest_3967 {

    void testByte() {
        final byte fb = 0;
        Byte b = fb;
        Short s = fb;
        Character c = fb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3967().testByte();
    }
}
