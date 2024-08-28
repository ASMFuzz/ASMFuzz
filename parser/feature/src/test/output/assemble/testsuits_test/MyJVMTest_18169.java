public class MyJVMTest_18169 {

    static short[] sa = { 0, -14396, 32767, -32768, 32767, 32767, 19905, 0, 0, 0 };

    long _loadS2LmaskFF(short[] sa) {
        return sa[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18169()._loadS2LmaskFF(sa));
    }
}
