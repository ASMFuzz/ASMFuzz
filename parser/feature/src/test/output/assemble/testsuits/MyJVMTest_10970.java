public class MyJVMTest_10970 {

    static byte[] ba = { -56, 9, -24, -60, 87, -43, 19, 42, 124, -7 };

    long loadB2L_mask8_1(byte[] ba) {
        return ba[0] & 0x55;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10970().loadB2L_mask8_1(ba));
    }
}
