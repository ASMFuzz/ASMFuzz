public class MyJVMTest_8341 {

    static short[] a = { 32767, -32768, -32768, -32768, 0, -32768, 32767, -32768, 10257, 32767 };

    static Short result2 = 20077;

    short sump2(short[] a, Short result2) {
        Short result1 = 1;
        for (Short i : a) {
            result1 = (short) (result1 + i);
            result2 = (short) (result2 + i + 1);
        }
        return (short) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8341().sump2(a, result2));
    }
}
