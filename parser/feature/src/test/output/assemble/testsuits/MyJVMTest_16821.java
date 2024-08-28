public class MyJVMTest_16821 {

    String getName() {
        return "Custom L&F";
    }

    static boolean useAAHints = false;

    String getID() {
        return getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16821().getID());
    }
}
