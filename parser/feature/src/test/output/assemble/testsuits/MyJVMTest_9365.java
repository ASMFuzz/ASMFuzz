public class MyJVMTest_9365 {

    static short[] sa = { -32768, 32767, 32767, 32767, 32767, 0, -32768, 0, 0, 0 };

    long loadS2Lmask13(short[] sa) {
        return sa[0] & 0x0FFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9365().loadS2Lmask13(sa));
    }
}
