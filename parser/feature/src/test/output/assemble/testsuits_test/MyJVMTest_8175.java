public class MyJVMTest_8175 {

    long foo() {
        return 10l;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8175().foo());
    }
}
