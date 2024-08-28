public class MyJVMTest_14746 {

    static int n = 2;

    static int nonStaticPublicField = 0;

    int addPublicVariableArity(int... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14746().addPublicVariableArity(n));
    }
}
