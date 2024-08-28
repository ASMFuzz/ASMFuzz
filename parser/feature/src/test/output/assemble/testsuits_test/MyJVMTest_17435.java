public class MyJVMTest_17435 {

    static short[] sa = { 32767, 32767, 32767, 0, 32767, 32767, -32768, 24046, 0, 0 };

    long loadS2LmaskFF(short[] sa) {
        return sa[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17435().loadS2LmaskFF(sa));
    }
}
