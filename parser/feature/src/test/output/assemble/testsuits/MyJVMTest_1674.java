public class MyJVMTest_1674 {

    static short i = -24354;

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
        System.out.println(new MyJVMTest_1674().test_deop(i));
    }
}
