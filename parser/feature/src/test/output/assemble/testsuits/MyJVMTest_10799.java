public class MyJVMTest_10799 {

    static String name = "qsZ50:Dz:$";

    static int sum = 1;

    int sum(int sum) {
        if (this.sum == 0)
            this.sum = sum;
        if (this.sum != sum)
            throw new AssertionError("Sum mismatch");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10799().sum(sum);
    }
}
