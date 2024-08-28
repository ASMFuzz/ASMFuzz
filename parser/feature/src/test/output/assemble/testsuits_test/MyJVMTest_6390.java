public class MyJVMTest_6390 {

    void go() {
        System.out.println("Inner completing!");
    }

    void boo() {
        try {
            ClassLoader.getSystemClassLoader().loadClass("InnerTarg$TheInner");
        } catch (Exception exc) {
            System.out.println("Loading class got " + exc);
        }
        go();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6390().boo();
    }
}
