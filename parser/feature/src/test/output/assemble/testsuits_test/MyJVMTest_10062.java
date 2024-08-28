public class MyJVMTest_10062 {

    static int n = 6;

    static int nonStaticPublicField = 5;

    int addPublicStaticVariableArity(int... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10062().addPublicStaticVariableArity(n));
    }
}
