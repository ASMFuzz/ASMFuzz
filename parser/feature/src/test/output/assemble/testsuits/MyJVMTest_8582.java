public class MyJVMTest_8582 {

    void test2() {
        float[] fla = new float[1000];
        for (int i = 0; i < 1000; i++) {
            for (float fl2 : fla) {
                fla[100] = 1.0f;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 14; j++) {
                fla[2] = fla[j];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8582().test2();
    }
}
