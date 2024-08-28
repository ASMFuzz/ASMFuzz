public class MyJVMTest_11006 {

    static byte[][] garbage = {{78,4,120,-42,102,-78,-47,82,-82,103},{-2,65,-72,-55,-23,-23,-104,19,81,-18}};

    static int id = -1;

    void discardAndGC() {
        garbage = null;
        System.gc();
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11006().discardAndGC();
    }
}
