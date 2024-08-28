public class MyJVMTest_9063 {

    static int val = 0;

    int testRorAddInt32(int val) {
        return (val >>> 32) + (val << (32 - 32));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9063().testRorAddInt32(val));
    }
}
