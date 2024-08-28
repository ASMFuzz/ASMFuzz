public class MyJVMTest_10627 {

    void setAtoB() {
        try {
            a = (A) ClassLoader.getSystemClassLoader().loadClass("B").getConstructor(new Class[] {}).newInstance(new Object[] {});
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static A a = new A();

    static boolean is_in_loop = false;

    static boolean stop_while_loop = false;

    void run() {
        while (!is_in_loop) {
        }
        G.setAtoB();
        stop_while_loop = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10627().run();
    }
}
