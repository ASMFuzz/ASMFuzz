public class MyJVMTest_2911 {

    static int x = 1;

    static int y = 0;

    int compUnsigned(int x, int y) {
        int sign_x = x & Integer.MIN_VALUE;
        int sign_y = y & Integer.MIN_VALUE;
        int mant_x = x & (~Integer.MIN_VALUE);
        int mant_y = y & (~Integer.MIN_VALUE);
        if (sign_x == sign_y)
            return Integer.compare(mant_x, mant_y);
        else {
            if (sign_x == 0)
                return -1;
            else
                return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2911().compUnsigned(x, y));
    }
}
