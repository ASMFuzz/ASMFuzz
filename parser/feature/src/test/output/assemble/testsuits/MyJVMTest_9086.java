public class MyJVMTest_9086 {

    static int val = 0;

    int testRorOrInt31Or(int val) {
        return val | ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9086().testRorOrInt31Or(val));
    }
}
