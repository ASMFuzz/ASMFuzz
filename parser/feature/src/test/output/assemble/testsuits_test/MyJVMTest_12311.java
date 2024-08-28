import java.util.Arrays;

public class MyJVMTest_12311 {

    void test_char() {
        char[] a = new char[16];
        for (int i = 0; i < 200000; i++) {
            int start = i & 7;
            int end = start + ((i >> 4) & 7);
            char value = (char) i;
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
        new MyJVMTest_12311().test_char();
    }
}
