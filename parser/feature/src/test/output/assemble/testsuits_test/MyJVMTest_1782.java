public class MyJVMTest_1782 {

    static byte[][] garbage = {{-93,25,-70,-15,77,63,85,119,99,79},{-65,-114,90,53,-45,29,68,27,-18,-99}};

    static int id = -1;

    void discardAndGC() {
        garbage = null;
        System.gc();
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1782().discardAndGC();
    }
}
