public class MyJVMTest_16311 {

    static short[] sa = new short[] { -1 };

    long loadUS2L(short[] sa) {
        return sa[0] & 0xFFFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16311().loadUS2L(sa));
    }
}
