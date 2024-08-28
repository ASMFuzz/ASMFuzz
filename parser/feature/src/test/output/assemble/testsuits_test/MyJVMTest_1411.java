public class MyJVMTest_1411 {

    static short i = 0;

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
        System.out.println(new MyJVMTest_1411().simplef_deop(i));
    }
}
