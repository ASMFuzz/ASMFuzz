public class MyJVMTest_1936 {

    static int i = 49909507;

    int foo(int i) {
        return i;
    }

    void dummy() {
    }

    int testb_deop(int i) {
        Integer ib = foo(i);
        if ((i & 1) == 0)
            ib = foo(i + 1);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1936().testb_deop(i));
    }
}
