public class MyJVMTest_2736 {

    static int val = 9;

    int testRorOrInt31Or(int val) {
        return val | ((val >>> 31) | (val << (32 - 31)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2736().testRorOrInt31Or(val));
    }
}
