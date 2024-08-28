public class MyJVMTest_4195 {

    static short i = 10241;

    short foo(short i) {
        return i;
    }

    void dummy() {
    }

    short simpleb_deop(short i) {
        Short ib = Short.valueOf(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4195().simpleb_deop(i));
    }
}
