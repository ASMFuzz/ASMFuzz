public class MyJVMTest_3143 {

    static Float j = Float.POSITIVE_INFINITY;

    float remi_sump(Float j) {
        for (int i = 0; i < 1000; i++) {
            j = new Float(j + 1.f);
        }
        return j;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3143().remi_sump(j));
    }
}
