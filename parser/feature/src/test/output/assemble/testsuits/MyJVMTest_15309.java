public class MyJVMTest_15309 {

    static byte[] ba = new byte[] { -1 };

    long loadUB2L(byte[] ba) {
        return ba[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15309().loadUB2L(ba));
    }
}
