public class MyJVMTest_10990 {

    static Float j1 = Float.POSITIVE_INFINITY;

    float remi_sump2(Float j1) {
        Float j2 = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            j1 = new Float(j1 + 1.f);
            j2 = j2 + 2.f;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10990().remi_sump2(j1));
    }
}
