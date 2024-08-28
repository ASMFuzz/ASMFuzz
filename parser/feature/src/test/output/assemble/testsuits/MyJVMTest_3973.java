public class MyJVMTest_3973 {

    static int val = 6;

    int testRorAddInt1(int val) {
        return (val >>> 1) + (val << (32 - 1));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3973().testRorAddInt1(val));
    }
}
