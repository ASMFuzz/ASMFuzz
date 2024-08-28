public class MyJVMTest_1932 {

    static boolean useAAHints = true;

    String getName() {
        return "Custom L&F";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1932().getName());
    }
}
