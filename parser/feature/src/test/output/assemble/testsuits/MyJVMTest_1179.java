public class MyJVMTest_1179 {

    static int val = 6;

    int testRorAddInt16(int val) {
        return (val >>> 16) + (val << (32 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1179().testRorAddInt16(val));
    }
}
