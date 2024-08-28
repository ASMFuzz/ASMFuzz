import java.util.Arrays;

public class MyJVMTest_10999 {

    void test_float() {
        float[] a = new float[16];
        for (int i = 0; i < 200000; i++) {
            int start = i & 7;
            int end = start + ((i >> 4) & 7);
            float value = (float) i;
            if ((i & 1) == 1)
                value = -value;
            Arrays.fill(a, start, end, value);
            boolean error = false;
            for (int j = start; j < end; j++) {
                if (a[j] != value) {
                    System.err.println("a[" + j + "] = " + a[j] + " != " + value + " for " + a.length);
                    error = true;
                }
            }
            if (error)
                throw new InternalError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10999().test_float();
    }
}
