public class MyJVMTest_10624 {

    static short i = 32767;

    Short foob(short i) {
        return Short.valueOf(i);
    }

    void dummy() {
    }

    short simplef_deop(short i) {
        Short ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10624().simplef_deop(i));
    }
}
