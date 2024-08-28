public class MyJVMTest_17748 {

    long foo() {
        return 10l;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17748().foo());
    }
}
