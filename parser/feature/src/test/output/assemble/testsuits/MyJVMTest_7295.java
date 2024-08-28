public class MyJVMTest_7295 {

    String getName() {
        return "Custom L&F";
    }

    static boolean useAAHints = true;

    String getID() {
        return getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7295().getID());
    }
}
