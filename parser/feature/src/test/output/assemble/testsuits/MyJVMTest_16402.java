public class MyJVMTest_16402 {

    static short[] sa = { -32768, -32768, 16753, 32767, 23131, 32189, -32190, 12286, 3234, 0 };

    long _loadS2Lmask13(short[] sa) {
        return sa[0] & 0x0FFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16402()._loadS2Lmask13(sa));
    }
}
