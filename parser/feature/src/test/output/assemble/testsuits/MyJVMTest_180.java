public class MyJVMTest_180 {

    static int protectedInstance = -1830996404;

    int protectedInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_180().protectedInstance());
    }
}
