public class MyJVMTest_17960 {

    static int privateInstance = 0;

    int privateInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17960().privateInstance());
    }
}
