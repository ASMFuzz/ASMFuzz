public class MyJVMTest_6701 {

    static String a = "P.Vks><29t";

    static int b = 3;

    boolean isZero(int d) {
        switch(d) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    int useSecondArgument(String a, int b) {
        if (!isZero(b))
            throw new RuntimeException("isZero(0) returns false?!");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6701().useSecondArgument(a, b);
    }
}
