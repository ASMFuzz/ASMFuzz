public class MyJVMTest_15513 {

    static int publicInstance = 0;

    int publicInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15513().publicInstance());
    }
}
