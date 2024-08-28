public class MyJVMTest_6831 {

    static short[] a = { 4345, -32768, 0, 0, 0, 32767, 31923, 32767, -15623, 290 };

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
        System.out.println(new MyJVMTest_6831().sumb2(a));
    }
}
