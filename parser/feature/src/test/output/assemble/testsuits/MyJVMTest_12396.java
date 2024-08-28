public class MyJVMTest_12396 {

    static int n = 1602214020;

    static int nonStaticPublicField = -284357839;

    static int nonStaticFinalPublicField = 8;

    int addPublicVariableArity(int... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12396().addPublicVariableArity(n));
    }
}
