public class MyJVMTest_4553 {

    static int val = 619408661;

    static long sampleCount = -4656382171262237593L;

    static long[] disparity = {9223372036854775807L,1350030100995329545L,0,-6413514619435823787L,-787173164758691159L,9223372036854775807L,0,0,-9223372036854775808L,0};

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
        System.out.println(new MyJVMTest_4553().update(val));
    }
}
