public class MyJVMTest_6640 {

    static int val = -1384889292;

    int testRorAddInt32(int val) {
        return (val >>> 32) + (val << (32 - 32));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6640().testRorAddInt32(val));
    }
}
