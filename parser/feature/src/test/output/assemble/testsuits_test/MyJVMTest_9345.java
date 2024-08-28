public class MyJVMTest_9345 {

    static short[] sa = { 32767, 0, 32767, -32768, 32767, -32768, 0, 30579, 26156, -32768 };

    long loadS2Lmask16_1(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9345().loadS2Lmask16_1(sa));
    }
}
