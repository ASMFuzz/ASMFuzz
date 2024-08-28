public class MyJVMTest_11361 {

    static int staticInt = 0xBEBE;

    int meth4() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11361().meth4());
    }
}
