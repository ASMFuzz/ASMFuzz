public class MyJVMTest_14806 {

    static int NUM = 1024;

    static short[] in1 = new short[2 * NUM];

    static short[] in2 = new short[2 * NUM];

    short[] Vec_MulAddS2IInit(short[] in1, short[] in2) {
        for (int i = 0; i < 2 * NUM; i++) {
            in1[i] = (short) 4;
            in2[i] = (short) 5;
        }
        return in1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14806().Vec_MulAddS2IInit(in1, in2);
    }
}
