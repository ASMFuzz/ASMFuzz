public class MyJVMTest_10563 {

    static int packageInstance = 0;

    int packageInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10563().packageInstance());
    }
}
