public class MyJVMTest_12026 {

    static int val = -315724896;

    int testRorOrInt31Or(int val) {
        return val | ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12026().testRorOrInt31Or(val));
    }
}
