public class MyJVMTest_2153 {

    static Object n = 8;

    static int nonStaticPublicField = -1311683658;

    static int nonStaticFinalPublicField = 0;

    int addPublicVariableArity(Object... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += (int) n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2153().addPublicVariableArity(n));
    }
}
