import java.util.Arrays;

public class MyJVMTest_11173 {

    void test_byte() {
        for (int i = 0; i < 200000; i++) {
            byte[] a = new byte[16];
            int start = i & 7;
            int end = start + ((i >> 4) & 7);
            byte value = (byte) i;
            if ((i & 1) == 1)
                value = (byte) -value;
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
        new MyJVMTest_11173().test_byte();
    }
}
