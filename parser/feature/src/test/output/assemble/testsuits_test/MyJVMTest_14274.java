public class MyJVMTest_14274 {

    static Float ibc = new Float(1.f);

    float simplec() {
        Float ib = ibc;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14274().simplec());
    }
}
