public class MyJVMTest_12210 {

    static int x = 7;

    static int y = 3;

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
        System.out.println(new MyJVMTest_12210().compUnsigned(x, y));
    }
}
