public class MyJVMTest_3085 {

    static int n = 0;

    static int nonStaticPublicField = 2;

    static int nonStaticFinalPublicField = 4;

    int addPublicVariableArity(int... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3085().addPublicVariableArity(n));
    }
}
