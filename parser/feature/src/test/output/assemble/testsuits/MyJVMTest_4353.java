public class MyJVMTest_4353 {

    static float i = Float.POSITIVE_INFINITY;

    static Float ibc = new Float(1.f);

    float simplec2(float i) {
        Float ib1 = ibc;
        Float ib2 = Float.valueOf(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4353().simplec2(i));
    }
}
