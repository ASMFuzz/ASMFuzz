public class MyJVMTest_6598 {

    static int staticInt = 0xBEBE;

    int meth2() {
        return 200;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6598().meth2());
    }
}
