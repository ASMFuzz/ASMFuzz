public class MyJVMTest_477 {

    float remi_sumb2() {
        Float j1 = Float.valueOf(1.f);
        Float j2 = Float.valueOf(1.f);
        for (int i = 0; i < 1000; i++) {
            j1 = j1 + 1.f;
            j2 = j2 + 2.f;
        }
        return j1 + j2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_477().remi_sumb2());
    }
}
