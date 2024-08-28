public class MyJVMTest_8577 {

    static short[] sa = { 5344, -28446, -15515, 2074, 32767, 20322, 32767, 0, -1016, 5187 };

    long _loadS2LmaskFF(short[] sa) {
        return sa[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8577()._loadS2LmaskFF(sa));
    }
}
