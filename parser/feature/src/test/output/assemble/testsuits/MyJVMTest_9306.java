public class MyJVMTest_9306 {

    static int i = 0;

    int foo(int i) {
        return i;
    }

    void dummy() {
    }

    int simple_deop(int i) {
        Integer ib = new Integer(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9306().simple_deop(i));
    }
}
