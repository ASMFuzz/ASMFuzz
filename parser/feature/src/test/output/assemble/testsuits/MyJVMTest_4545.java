public class MyJVMTest_4545 {

    void testParent() {
        System.out.println("SuperClazz: entering testParent()");
        System.out.println("parent-transform-check: this-should-be-transformed");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4545().testParent();
    }
}
