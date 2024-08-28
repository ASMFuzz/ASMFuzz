public class MyJVMTest_1379 {

    static short[] sa = { 32767, -32768, -32768, 0, 17757, 32767, 32767, -32768, 2061, -32768 };

    long loadS2Lmask13_1(short[] sa) {
        return sa[0] & 0x0FFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1379().loadS2Lmask13_1(sa));
    }
}
