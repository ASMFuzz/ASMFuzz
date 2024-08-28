public class MyJVMTest_16268 {

    static short[] a = { -22584, 32767, 12139, -32768, -32768, -32768, 0, 32767, 0, 26166 };

    static Short result = 0;

    short sump(short[] a, Short result) {
        for (Short i : a) result = (short) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16268().sump(a, result));
    }
}
