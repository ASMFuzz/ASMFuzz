public class MyJVMTest_16334 {

    static short[] sa = { 5341, 10692, 9673, -32768, -32768, 32767, 0, -1043, 32767, 0 };

    long loadS2Lmask16(short[] sa) {
        return sa[0] & 0xFFFE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16334().loadS2Lmask16(sa));
    }
}
