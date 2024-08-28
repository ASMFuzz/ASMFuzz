public class MyJVMTest_10752 {

    static Float ibc = new Float(1.f);

    float remi_sumc2() {
        Float j1 = ibc;
        Float j2 = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + ibc;
            j2 = j2 + 2.f;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10752().remi_sumc2());
    }
}
