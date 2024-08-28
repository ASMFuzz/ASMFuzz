public class MyJVMTest_26 {

    static byte[] ba = new byte[] { -1 };

    long loadB2L(byte[] ba) {
        return ba[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_26().loadB2L(ba));
    }
}
