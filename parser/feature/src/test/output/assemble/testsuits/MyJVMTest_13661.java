public class MyJVMTest_13661 {

    static short[] a = { 32767, 0, 27148, -32768, 0, 32767, 0, 32767, 8460, 17947 };

    short sumb(short[] a) {
        Short result = 1;
        for (Short i : a) result = (short) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13661().sumb(a));
    }
}
