public class MyJVMTest_9009 {

    static int val = -1111225501;

    int testRorOrInt1Or(int val) {
        return val | ((val >>> 1) | (val << (32 - 1)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9009().testRorOrInt1Or(val));
    }
}
