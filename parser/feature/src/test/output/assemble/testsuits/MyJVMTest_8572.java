public class MyJVMTest_8572 {

    static boolean DEBUG = true;

    void doIt() throws Exception {
        if (DEBUG) {
            System.out.println("OK");
        } else {
            System.out.println("FAILED in inner");
            throw new Exception("FAILED in inner");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8572().doIt();
    }
}
