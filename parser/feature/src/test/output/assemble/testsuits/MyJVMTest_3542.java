public class MyJVMTest_3542 {

    static int staticInt = 0xBABE;

    int meth1() {
        return 123;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3542().meth1());
    }
}
