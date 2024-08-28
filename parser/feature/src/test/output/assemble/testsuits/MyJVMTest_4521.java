public class MyJVMTest_4521 {

    static Object o = 7;

    static int i = 1985526387;

    static Object field2 = 64555958;

    static int field = 2;

    Object inlined(Object o, int i) {
        if (i != 4) {
            field2 = o;
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4521().inlined(o, i);
    }
}
