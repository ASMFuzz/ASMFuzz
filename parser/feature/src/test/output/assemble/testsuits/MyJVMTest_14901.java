public class MyJVMTest_14901 {

    static String prev = "pc+,^8xNvr";

    String foo(String prev) {
        return prev + "Here ";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14901().foo(prev));
    }
}
