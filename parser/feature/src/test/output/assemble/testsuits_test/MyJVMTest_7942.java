public class MyJVMTest_7942 {

    static int staticInt = 0xBEBE;

    int meth1() {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7942().meth1());
    }
}
