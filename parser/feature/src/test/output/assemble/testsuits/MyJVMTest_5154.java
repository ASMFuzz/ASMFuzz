public class MyJVMTest_5154 {

    static String name = "OR_<];,:A5";

    static int sum = 0;

    int deoptimize(int sum) {
        if (sum == 42)
            System.out.println("the answer");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5154().deoptimize(sum);
    }
}
