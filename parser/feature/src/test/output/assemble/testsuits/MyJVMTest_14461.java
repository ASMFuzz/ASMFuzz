public class MyJVMTest_14461 {

    static String prev = "PMM`*y_#\"8";

    String foo(String prev) {
        return prev + "Boring ";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14461().foo(prev));
    }
}
