public class MyJVMTest_13612 {

    long capacity() {
        return Runtime.getRuntime().totalMemory();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13612().capacity());
    }
}
