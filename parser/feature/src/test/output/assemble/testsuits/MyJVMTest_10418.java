public class MyJVMTest_10418 {

    String method2() {
        return "Impl.method2";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10418().method2());
    }
}
