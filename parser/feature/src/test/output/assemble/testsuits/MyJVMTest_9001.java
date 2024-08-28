public class MyJVMTest_9001 {

    static int val = 8;

    int testRorAddInt16(int val) {
        return (val >>> 16) + (val << (32 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9001().testRorAddInt16(val));
    }
}
