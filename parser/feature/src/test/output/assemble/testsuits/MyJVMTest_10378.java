public class MyJVMTest_10378 {

    static int val = 1;

    int testRorAddInt16(int val) {
        return (val >>> 16) + (val << (32 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10378().testRorAddInt16(val));
    }
}
