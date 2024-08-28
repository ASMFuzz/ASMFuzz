public class MyJVMTest_12120 {

    static short[] sa = { 32338, 17655, 32767, 32767, 0, 0, 19676, 0, -32768, -32768 };

    long _loadS2Lmask16(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12120()._loadS2Lmask16(sa));
    }
}
