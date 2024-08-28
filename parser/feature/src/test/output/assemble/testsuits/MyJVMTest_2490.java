public class MyJVMTest_2490 {

    static int i = 0;

    static int i_0_ = 0;

    static int[] a = {0,8,0,0,-2015815590,2,0,0,3,5};

    static int idx = 0;

    int loop_back(int i, int i_0_) {
        int i_1_ = 0;
        int[] is = a;
        if (is == null)
            return 0;
        for (int i_2_ = i; i_2_ >= i_0_; i_2_--) i_1_ += is[idx = i_2_];
        return i_1_;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2490().loop_back(i, i_0_));
    }
}
