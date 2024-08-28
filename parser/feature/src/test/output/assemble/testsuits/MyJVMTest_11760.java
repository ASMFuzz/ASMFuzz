public class MyJVMTest_11760 {

    static int i = 1746964113;

    static int i_0_ = 0;

    static int[] a = {0,1,8,9,-958498407,0,2,2,9,1715996881};

    static int idx = 4;

    int loop_back(int i, int i_0_) {
        int i_1_ = 0;
        int[] is = a;
        if (is == null)
            return 0;
        for (int i_2_ = i; i_2_ >= i_0_; i_2_--) i_1_ += is[idx = i_2_];
        return i_1_;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11760().loop_back(i, i_0_));
    }
}
