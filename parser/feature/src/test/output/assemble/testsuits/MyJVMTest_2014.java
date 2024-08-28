public class MyJVMTest_2014 {

    static short i = 0;

    short foo(short i) {
        return i;
    }

    void dummy() {
    }

    short testb_deop(short i) {
        Short ib = foo(i);
        if ((i & 1) == 0)
            ib = foo((short) (i + 1));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2014().testb_deop(i));
    }
}
