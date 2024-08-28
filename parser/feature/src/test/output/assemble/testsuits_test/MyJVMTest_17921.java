public class MyJVMTest_17921 {

    static short[] a = { 32767, 32767, -32768, 0, 0, -32768, 19759, -32768, 0, -12203 };

    static Short result2 = 0;

    short sump2(short[] a, Short result2) {
        Short result1 = 1;
        for (Short i : a) {
            result1 = (short) (result1 + i);
            result2 = (short) (result2 + i + 1);
        }
        return (short) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17921().sump2(a, result2));
    }
}
