public class MyJVMTest_13727 {

    static float i = Float.NEGATIVE_INFINITY;

    static Float ibc = new Float(1.f);

    float simplec2(float i) {
        Float ib1 = ibc;
        Float ib2 = Float.valueOf(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13727().simplec2(i));
    }
}
