public class MyJVMTest_12645 {

    static float i = Float.MAX_VALUE;

    void dummy() {
    }

    static Float ibc = new Float(1.f);

    float simplec_deop(float i) {
        Float ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12645().simplec_deop(i));
    }
}
