public class MyJVMTest_15832 {

    static short i = -32768;

    Short foob(short i) {
        return Short.valueOf(i);
    }

    short simplef(short i) {
        Short ib = foob(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15832().simplef(i));
    }
}
