public class MyJVMTest_5468 {

    static int staticInt = 0xBABE;

    int meth4() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5468().meth4());
    }
}
