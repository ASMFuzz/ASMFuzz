public class MyJVMTest_10747 {

    static float i = 0f;

    static Float ib1 = 0f;

    float simplep2(float i, Float ib1) {
        Float ib2 = Float.valueOf(i + 1.f);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10747().simplep2(i, ib1));
    }
}
