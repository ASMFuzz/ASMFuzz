public class MyJVMTest_15837 {

    static int n = 6;

    static int offset = 0;

    static byte[] data = {4,-78,55,-6,126,-52,-32,79,-105,46};

    int skipBytes(int n) {
        offset += n;
        return n;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15837().skipBytes(n);
    }
}
