public class MyJVMTest_4675 {

    static byte[] ba = new byte[] { -1 };

    int loadB(byte[] ba) {
        return ba[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4675().loadB(ba));
    }
}
