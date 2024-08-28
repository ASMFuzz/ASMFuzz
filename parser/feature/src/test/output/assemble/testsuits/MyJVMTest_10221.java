public class MyJVMTest_10221 {

    static int packageStatic = 1;

    int packageStatic() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10221().packageStatic());
    }
}
