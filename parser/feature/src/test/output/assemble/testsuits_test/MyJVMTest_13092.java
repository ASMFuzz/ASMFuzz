public class MyJVMTest_13092 {

    static long i = 0;

    long foo(long i) {
        return i;
    }

    void dummy() {
    }

    long simpleb_deop(long i) {
        Long ib = Long.valueOf(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13092().simpleb_deop(i));
    }
}
