public class MyJVMTest_9330 {

    static int protectedInstance = 0;

    int protectedInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9330().protectedInstance());
    }
}
