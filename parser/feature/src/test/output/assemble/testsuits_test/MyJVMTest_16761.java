public class MyJVMTest_16761 {

    static int i = 0;

    int foo(int i) {
        return i;
    }

    void dummy() {
    }

    int test_deop(int i) {
        Integer ib = new Integer(foo(i));
        if ((i & 1) == 0)
            ib = foo(i + 1);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16761().test_deop(i));
    }
}
