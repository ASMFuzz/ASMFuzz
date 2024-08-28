public class MyJVMTest_15686 {

    static int staticInt = 0xBEBE;

    int meth3() {
        return 300;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15686().meth3());
    }
}
