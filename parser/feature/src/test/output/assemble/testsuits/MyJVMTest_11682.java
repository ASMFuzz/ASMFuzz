public class MyJVMTest_11682 {

    static short i = -32768;

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
        System.out.println(new MyJVMTest_11682().simple_deop(i));
    }
}
