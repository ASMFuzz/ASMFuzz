public class MyJVMTest_17261 {

    static A a = new A();

    void setAtoB() {
        try {
            a = (A) ClassLoader.getSystemClassLoader().loadClass("B").getConstructor(new Class[] {}).newInstance(new Object[] {});
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17261().setAtoB();
    }
}
