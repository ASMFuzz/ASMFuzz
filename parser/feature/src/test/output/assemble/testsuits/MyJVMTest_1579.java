public class MyJVMTest_1579 {

    static String name = "|iDlli?LNu";

    static int sum = 5;

    int sum(int sum) {
        if (this.sum == 0)
            this.sum = sum;
        if (this.sum != sum)
            throw new AssertionError("Sum mismatch");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1579().sum(sum);
    }
}
