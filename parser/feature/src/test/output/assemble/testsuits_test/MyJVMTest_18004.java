public class MyJVMTest_18004 {

    int meth1() {
        return 100;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18004().meth1());
    }
}
