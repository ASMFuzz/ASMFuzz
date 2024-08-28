public class MyJVMTest_9066 {

    String getName() {
        return "Custom L&F";
    }

    static boolean useAAHints = true;

    String getID() {
        return getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9066().getID());
    }
}
