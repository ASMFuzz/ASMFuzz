public class MyJVMTest_2824 {

    static short[] sa = { 32767, -19491, 32767, -32768, -32768, 12794, 0, 32767, 32767, 32767 };

    long _loadS2Lmask16(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2824()._loadS2Lmask16(sa));
    }
}
