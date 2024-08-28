public class MyJVMTest_9041 {

    static int val = 9;

    int testRorAddInt1(int val) {
        return (val >>> 1) + (val << (32 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9041().testRorAddInt1(val));
    }
}
