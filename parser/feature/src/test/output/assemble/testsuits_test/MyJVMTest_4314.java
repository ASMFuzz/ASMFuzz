public class MyJVMTest_4314 {

    static short[] sa = { -32768, -7071, -22436, 32767, -32768, 860, 32767, 0, 0, 0 };

    long loadS2LmaskFF_1(short[] sa) {
        return sa[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4314().loadS2LmaskFF_1(sa));
    }
}
