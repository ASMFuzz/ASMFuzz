public class MyJVMTest_7657 {

    static int x = 0;

    static int y = 0;

    static int count = 476014358;

    static int MAX_DASH_LENGTH = 3;

    int checkCount(final int x, final int y, final int count) {
        if (count > MAX_DASH_LENGTH) {
            throw new RuntimeException("Dash is longer than " + MAX_DASH_LENGTH + " at " + x + ", " + y);
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7657().checkCount(x, y, count);
    }
}
