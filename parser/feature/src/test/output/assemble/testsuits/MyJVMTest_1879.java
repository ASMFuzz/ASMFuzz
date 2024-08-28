public class MyJVMTest_1879 {

    static int sum = 0;

    int sum(int sum) {
        if (this.sum == 0)
            this.sum = sum;
        if (this.sum != sum)
            throw new AssertionError("Sum mismatch");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1879().sum(sum);
    }
}
