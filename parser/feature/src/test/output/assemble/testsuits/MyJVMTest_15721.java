public class MyJVMTest_15721 {

    static int first = 421517297;

    static int second = -513337827;

    boolean isEqual(final int first, final int second) {
        return (first == second);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15721().isEqual(first, second));
    }
}
