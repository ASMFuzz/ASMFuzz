public class MyJVMTest_1032 {

    static int packageStatic = 0;

    int packageStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1032().packageStatic());
    }
}
