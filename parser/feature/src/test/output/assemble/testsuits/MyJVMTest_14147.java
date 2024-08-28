public class MyJVMTest_14147 {

    static int x = 3;

    static int y = 0;

    int add(int x, int y) {
        long rslt = (long) x + (long) y;
        if (Integer.MIN_VALUE <= rslt && rslt <= Integer.MAX_VALUE) {
            return (int) rslt;
        }
        String msg = String.format("Integer overflow: %d + %d.", x, y);
        throw new IllegalArgumentException(msg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14147().add(x, y));
    }
}
