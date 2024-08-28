public class MyJVMTest_12459 {

    static Float j = Float.NEGATIVE_INFINITY;

    float remi_sump(Float j) {
        for (int i = 0; i < 1000; i++) {
            j = new Float(j + 1.f);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12459().remi_sump(j));
    }
}
