public class MyJVMTest_16335 {

    static short[] a = { -25029, 32767, -32768, 32767, 0, -32768, 32767, 14179, -28970, 0 };

    short sumb2(short[] a) {
        Short result1 = 1;
        Short result2 = 1;
        for (Short i : a) {
            result1 = (short) (result1 + i);
            result2 = (short) (result2 + i + 1);
        }
        return (short) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16335().sumb2(a));
    }
}
