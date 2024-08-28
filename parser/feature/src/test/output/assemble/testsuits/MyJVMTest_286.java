public class MyJVMTest_286 {

    static int i = 2076285318;

    static long l = 2;

    static short s = 32767;

    void test() {
        l = 5;
        l = (new short[(byte) -2])[(byte) (l = i)];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_286().test();
    }
}
