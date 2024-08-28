public class MyJVMTest_12514 {

    float remi_summ2() {
        Float j1 = new Float(1.f);
        Float j2 = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            j1 = new Float(j1 + 1.f);
            j2 = j2 + 2.f;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12514().remi_summ2());
    }
}
