public class MyJVMTest_3478 {

    static byte[] ba = new byte[] { -1 };

    int loadUB(byte[] ba) {
        return ba[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3478().loadUB(ba));
    }
}
