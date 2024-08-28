public class MyJVMTest_17223 {

    int nonNative() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17223().nonNative());
    }
}
