public class MyJVMTest_4635 {

    static GCParams gcParams = null;

    static GCParams instance = null;

    GCParams setInstance(GCParams gcParams) {
        synchronized (GCParams.class) {
            instance = gcParams;
        }
        return gcParams;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4635().setInstance(gcParams);
    }
}
