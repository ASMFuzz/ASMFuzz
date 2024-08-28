public class MyJVMTest_16094 {

    static int staticInt = 0xBEBE;

    int meth2() {
        return 200;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16094().meth2());
    }
}
