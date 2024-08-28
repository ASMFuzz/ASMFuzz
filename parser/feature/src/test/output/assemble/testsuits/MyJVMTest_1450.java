public class MyJVMTest_1450 {

    static short[] a = { -32768, 0, 0, -32768, -27303, 32767, 32767, 32767, -32768, 6514 };

    short sum2(short[] a) {
        short result1 = 1;
        short result2 = 1;
        for (Short i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return (short) (result1 + result2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1450().sum2(a));
    }
}
