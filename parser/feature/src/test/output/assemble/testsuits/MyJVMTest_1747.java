public class MyJVMTest_1747 {

    static byte[] ba = { 29, 27, 94, 57, 65, 70, 83, 48, 51, -34 };

    long loadB2L_mask8_1(byte[] ba) {
        return ba[0] & 0x55;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1747().loadB2L_mask8_1(ba));
    }
}
