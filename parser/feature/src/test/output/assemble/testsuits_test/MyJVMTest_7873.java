public class MyJVMTest_7873 {

    static short[] sa = { 32767, -32768, 5429, -32768, 0, -32768, 32523, 0, 0, -32768 };

    long loadS2LmaskFF(short[] sa) {
        return sa[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7873().loadS2LmaskFF(sa));
    }
}
