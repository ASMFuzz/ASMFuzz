public class MyJVMTest_6357 {

    static int n = 8;

    static int offset = 7;

    static byte[] data = {82,-41,-88,41,-120,34,53,-119,111,74};

    int skipBytes(int n) {
        offset += n;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6357().skipBytes(n);
    }
}
