public class MyJVMTest_13558 {

    static short i = 23156;

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
        System.out.println(new MyJVMTest_13558().simpleb_deop(i));
    }
}
