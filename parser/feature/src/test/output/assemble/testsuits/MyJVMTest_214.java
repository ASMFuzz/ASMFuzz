public class MyJVMTest_214 {

    static short[] sa = { 28097, 32767, 0, 0, 32767, 0, 32767, -32768, 32767, 0 };

    long loadS2Lmask13(short[] sa) {
        return sa[0] & 0x0FFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_214().loadS2Lmask13(sa));
    }
}
