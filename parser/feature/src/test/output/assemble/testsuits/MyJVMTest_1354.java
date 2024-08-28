public class MyJVMTest_1354 {

    static int packageInstance = 1;

    int packageInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1354().packageInstance());
    }
}
