public class MyJVMTest_13350 {

    void run() {
        try {
            Class.forName(java.util.List.class.getName(), false, ClassLoader.getSystemClassLoader());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13350().run();
    }
}
