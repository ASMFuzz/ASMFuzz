public class MyJVMTest_16272 {

    static int val = 0;

    int testRorAddInt31(int val) {
        return (val >>> 31) + (val << (32 - 31));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16272().testRorAddInt31(val));
    }
}
