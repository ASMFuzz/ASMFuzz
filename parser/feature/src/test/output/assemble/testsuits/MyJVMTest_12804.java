public class MyJVMTest_12804 {

    String getName() {
        return "Custom L&F";
    }

    static boolean useAAHints = true;

    String getDescription() {
        return getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12804().getDescription());
    }
}
