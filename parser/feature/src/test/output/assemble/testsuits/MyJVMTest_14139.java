public class MyJVMTest_14139 {

    static int i = 0;

    static int field = 0;

    int inlined2(int i) {
        if (i != 42) {
            field = 42;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14139().inlined2(i);
    }
}
