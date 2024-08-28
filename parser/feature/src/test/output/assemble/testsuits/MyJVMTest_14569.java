public class MyJVMTest_14569 {

    static String name = "xIfixC#ZL4";

    static int sum = 6;

    int deoptimize(int sum) {
        if (sum == 42)
            System.out.println("the answer");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14569().deoptimize(sum);
    }
}
