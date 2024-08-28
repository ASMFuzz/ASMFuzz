public class MyJVMTest_881 {

    static int n = -1314912521;

    static int nonStaticPublicField = 3;

    int addPublicStaticVariableArity(int... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_881().addPublicStaticVariableArity(n));
    }
}
