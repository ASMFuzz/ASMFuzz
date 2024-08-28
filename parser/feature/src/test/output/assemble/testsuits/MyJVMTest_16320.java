import java.util.Random;

public class MyJVMTest_16320 {

    static int NUM = 1024;

    static int[] out = new int[NUM];

    static short[] in1 = new short[2 * NUM];

    static short[] in2 = new short[2 * NUM];

    int Vec_MulAddS2IImplement(short[] in1, short[] in2, int[] out) {
        for (int i = 0; i < NUM; i++) {
            out[i] += ((in1[2 * i] * in2[2 * i]) + (in1[2 * i + 1] * in2[2 * i + 1]));
        }
        Random rand = new Random();
        int n = rand.nextInt(NUM - 1);
        return out[n];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16320().Vec_MulAddS2IImplement(in1, in2, out));
    }
}
