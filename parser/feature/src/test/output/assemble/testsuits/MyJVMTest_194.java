public class MyJVMTest_194 {

    static short[] sa = { 25098, -32768, 32767, 32767, 0, 0, 0, 0, -12606, 32767 };

    long loadS2Lmask16_1(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_194().loadS2Lmask16_1(sa));
    }
}
