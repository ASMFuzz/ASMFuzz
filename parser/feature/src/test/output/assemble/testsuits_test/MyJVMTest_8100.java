public class MyJVMTest_8100 {

    int meth1() {
        return 123;
    }

    static int staticInt = 0xBABE;

    int meth2() {
        return meth1() * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8100().meth2());
    }
}
