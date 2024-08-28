public class MyJVMTest_6056 {

    static int publicInstance = 6;

    int publicInstance() {
        return 42;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6056().publicInstance());
    }
}
