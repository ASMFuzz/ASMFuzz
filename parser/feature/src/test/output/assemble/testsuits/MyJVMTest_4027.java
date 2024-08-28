public class MyJVMTest_4027 {

    static int less = 1858204273;

    static int count = 100;

    static int lastCount = 100;

    int checkUsage(int less) throws Exception {
        if (lastCount != count + less) {
            throw new Exception(String.format("lastCount = %d, count = %d, less = %d", lastCount, count, less));
        }
        lastCount = count;
        return less;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4027().checkUsage(less);
    }
}
