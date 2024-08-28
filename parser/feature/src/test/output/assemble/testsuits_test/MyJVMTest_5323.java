public class MyJVMTest_5323 {

    static int n = 5;

    static int nonStaticPublicField = 3;

    int addPublicVariableArity(int... n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5323().addPublicVariableArity(n));
    }
}
