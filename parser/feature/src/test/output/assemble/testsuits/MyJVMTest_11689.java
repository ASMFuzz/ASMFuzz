public class MyJVMTest_11689 {

    static int count = 0;

    static int waiters = 0;

    int set(int count) {
        if (waiters != 0) {
            throw new IllegalArgumentException();
        }
        this.count = count;
        this.waiters = 0;
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11689().set(count);
    }
}
