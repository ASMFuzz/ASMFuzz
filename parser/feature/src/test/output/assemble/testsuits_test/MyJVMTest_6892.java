public class MyJVMTest_6892 {

    static short[] sa = { 0, 32767, 0, 0, 32767, 32767, 32767, 32767, 29943, -32768 };

    long _loadS2Lmask13(short[] sa) {
        return sa[0] & 0x0FFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6892()._loadS2Lmask13(sa));
    }
}
