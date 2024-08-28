public class MyJVMTest_16136 {

    static int val = 6;

    int testRorAddInt32(int val) {
        return (val >>> 32) + (val << (32 - 32));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16136().testRorAddInt32(val));
    }
}
