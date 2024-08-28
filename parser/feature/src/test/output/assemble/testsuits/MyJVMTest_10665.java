public class MyJVMTest_10665 {

    static short[] a = { -16523, 0, -30816, -32768, 32767, 32767, -32768, -32768, 0, 6828 };

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
        System.out.println(new MyJVMTest_10665().sum2(a));
    }
}
