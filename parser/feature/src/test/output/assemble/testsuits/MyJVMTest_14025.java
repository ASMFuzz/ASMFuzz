public class MyJVMTest_14025 {

    static GCParams gcParams = null;

    static GCParams instance = null;

    GCParams setInstance(GCParams gcParams) {
        synchronized (GCParams.class) {
            instance = gcParams;
        }
        return gcParams;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14025().setInstance(gcParams);
    }
}
