public class MyJVMTest_10590 {

    static short[] sa = { -32768, 0, 4917, 32767, 0, 0, 32767, 23830, 0, -27599 };

    long loadS2Lmask13_1(short[] sa) {
        return sa[0] & 0x0FFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10590().loadS2Lmask13_1(sa));
    }
}
