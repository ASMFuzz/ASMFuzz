public class MyJVMTest_2114 {

    static int staticInt = 0xBEBE;

    int meth4() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2114().meth4());
    }
}
