public class MyJVMTest_6830 {

    static short[] sa = { 1274, -32768, 0, 32767, -32768, -32768, 0, -32768, 32767, 29681 };

    long loadS2Lmask16(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6830().loadS2Lmask16(sa));
    }
}
