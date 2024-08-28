public class MyJVMTest_13909 {

    static Object o = 847287338;

    static int i = 6;

    static Object field2 = 9;

    static int field = 2;

    Object inlined(Object o, int i) {
        if (i != 4) {
            field2 = o;
        }
        return o;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13909().inlined(o, i);
    }
}
