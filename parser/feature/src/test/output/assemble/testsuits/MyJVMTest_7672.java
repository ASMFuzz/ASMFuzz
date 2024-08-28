public class MyJVMTest_7672 {

    int nonNative() {
        return 10;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7672().nonNative());
    }
}
