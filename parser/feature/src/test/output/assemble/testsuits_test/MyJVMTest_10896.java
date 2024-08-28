public class MyJVMTest_10896 {

    static short i = -32768;

    short foo(short i) {
        return i;
    }

    void dummy() {
    }

    short test_deop(short i) {
        Short ib = new Short(foo(i));
        if ((i & 1) == 0)
            ib = foo((short) (i + 1));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10896().test_deop(i));
    }
}
