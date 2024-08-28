public class MyJVMTest_11403 {

    static Object n = -529493877;

    static int nonStaticPublicField = 6;

    static int nonStaticFinalPublicField = -397163056;

    int addPublicVariableArity(Object... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += (int) n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11403().addPublicVariableArity(n));
    }
}
