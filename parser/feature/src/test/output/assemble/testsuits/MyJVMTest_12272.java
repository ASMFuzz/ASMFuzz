public class MyJVMTest_12272 {

    static short[] a = { 32767, -32768, 32767, -32768, 32767, 0, 0, 32767, 32767, 32695 };

    short sum(short[] a) {
        short result = 1;
        for (Short i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12272().sum(a));
    }
}
