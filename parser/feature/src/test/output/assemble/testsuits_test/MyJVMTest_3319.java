public class MyJVMTest_3319 {

    static float i = Float.MIN_VALUE;

    void dummy() {
    }

    static Float ibc = new Float(1.f);

    float simplec_deop(float i) {
        Float ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3319().simplec_deop(i));
    }
}
