public class MyJVMTest_3753 {

    static long i = -6238561832546182130L;

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
        System.out.println(new MyJVMTest_3753().simpleb_deop(i));
    }
}
