public class MyJVMTest_14897 {

    static int staticInt = 0xBABE;

    int meth4() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14897().meth4());
    }
}
