public class MyJVMTest_2415 {

    static short i = 0;

    short foo(short i) {
        return i;
    }

    void dummy() {
    }

    short simple_deop(short i) {
        Short ib = new Short(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2415().simple_deop(i));
    }
}
