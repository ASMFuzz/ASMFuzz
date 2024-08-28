public class MyJVMTest_5415 {

    void test1() {
        float h = 0;
        for (int j = 0; j < 3; ++j) {
            float k = 9;
            float[] fla = new float[2];
            for (int n = 0; n < 5; ++n) {
                if (j >= 1) {
                    if (n <= 1) {
                        h += k;
                    }
                }
            }
            for (int l12 = 0; l12 < 9; ++l12) {
                for (int o = 0; o < 1; ++o) {
                    fla[0] += 1.0f;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5415().test1();
    }
}
