public class MyJVMTest_16197 {

    static String a = "tMp@u|kj8[";

    static int b = 0;

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
        new MyJVMTest_16197().useSecondArgument(a, b);
    }
}
