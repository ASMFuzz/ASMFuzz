public class MyJVMTest_13889 {

    static String[] stringArray = { "s", "t", "r" };

    void foo() {
        String str = "S = " + stringArray[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13889().foo();
    }
}
