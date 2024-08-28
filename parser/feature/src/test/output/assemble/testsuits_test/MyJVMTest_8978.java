public class MyJVMTest_8978 {

    static int val = -1934957199;

    int testRorAddInt31(int val) {
        return (val >>> 31) + (val << (32 - 31));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8978().testRorAddInt31(val));
    }
}
