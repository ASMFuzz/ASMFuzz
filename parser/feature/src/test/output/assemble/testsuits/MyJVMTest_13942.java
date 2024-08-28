public class MyJVMTest_13942 {

    static int val = 0;

    static long sampleCount = 9223372036854775807L;

    static long[] disparity = {0,3173318411343847834L,9223372036854775807L,-9223372036854775808L,5441580297602750656L,-9223372036854775808L,9223372036854775807L,-9223372036854775808L,-9223372036854775808L,0};

    static long sumPopCount = -9223372036854775808L;

    int update(int val) {
        int popCount = 0;
        for (int i = 0; i < 32; ++i) {
            if ((val & (1 << i)) != 0) {
                ++popCount;
                disparity[i] += 1;
            } else {
                disparity[i] -= 1;
            }
        }
        sumPopCount += popCount;
        ++sampleCount;
        return popCount;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13942().update(val));
    }
}
