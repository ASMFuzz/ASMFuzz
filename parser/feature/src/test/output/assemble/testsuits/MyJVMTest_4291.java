public class MyJVMTest_4291 {

    static short[] a = { 27609, 5783, 32767, -32768, 16343, 32767, -32768, 0, 32767, -32768 };

    short sumb(short[] a) {
        Short result = 1;
        for (Short i : a) result = (short) (result + i);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4291().sumb(a));
    }
}
