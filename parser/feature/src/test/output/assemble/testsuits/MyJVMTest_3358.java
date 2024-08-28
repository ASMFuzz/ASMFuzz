public class MyJVMTest_3358 {

    static byte[] ba = new byte[] { -1 };

    int loadUBmask(byte[] ba) {
        return ba[0] & 0xFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3358().loadUBmask(ba));
    }
}
