public class MyJVMTest_11293 {

    static byte[] ba = { 116, 108, -54, -98, 36, 117, -59, 48, -71, -125 };

    long _loadB2L_mask8(byte[] ba) {
        return ba[0] & 0x55;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11293()._loadB2L_mask8(ba));
    }
}
