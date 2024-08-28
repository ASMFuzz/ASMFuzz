public class MyJVMTest_4741 {

    static int i = 0;

    static int field = 8;

    int inlined2(int i) {
        if (i != 42) {
            field = 42;
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4741().inlined2(i);
    }
}
