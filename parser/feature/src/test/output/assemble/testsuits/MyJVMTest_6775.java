public class MyJVMTest_6775 {

    static int val = 5;

    int testRorAddInt31(int val) {
        return (val >>> 31) + (val << (32 - 31));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6775().testRorAddInt31(val));
    }
}
