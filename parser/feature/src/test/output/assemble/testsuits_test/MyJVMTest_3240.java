public class MyJVMTest_3240 {

    static GCParams instance = null;

    GCParams getInstance() {
        synchronized (GCParams.class) {
            if (instance == null)
                instance = new GCParams();
            return instance;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3240().getInstance());
    }
}
