public class MyJVMTest_13687 {

    static short[] sa = { -32768, 32767, 32767, 32767, -4354, 32767, 22757, 0, 21563, 0 };

    long loadS2LmaskFF_1(short[] sa) {
        return sa[0] & 0xFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13687().loadS2LmaskFF_1(sa));
    }
}
