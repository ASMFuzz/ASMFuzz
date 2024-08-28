public class MyJVMTest_17505 {

    static int staticInt = 0xBEBE;

    int meth1() {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17505().meth1());
    }
}
