public class MyJVMTest_3473 {

    String getName() {
        return "Custom L&F";
    }

    static boolean useAAHints = false;

    String getDescription() {
        return getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3473().getDescription());
    }
}
