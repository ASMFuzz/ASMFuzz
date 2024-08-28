public class MyJVMTest_4246 {

    long capacity() {
        return Runtime.getRuntime().totalMemory();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4246().capacity());
    }
}
