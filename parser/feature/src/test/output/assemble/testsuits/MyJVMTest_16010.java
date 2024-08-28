public class MyJVMTest_16010 {

    String method1() {
        return "Impl.method1";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16010().method1());
    }
}
