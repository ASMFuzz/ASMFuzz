public class MyJVMTest_5055 {

    float remi_sum2() {
        Float j1 = new Float(1.f);
        Float j2 = new Float(1.f);
        for (int i = 0; i < 1000; i++) {
            j1 = new Float(j1 + 1.f);
            j2 = new Float(j2 + 2.f);
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5055().remi_sum2());
    }
}
