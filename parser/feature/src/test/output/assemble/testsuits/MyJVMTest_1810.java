public class MyJVMTest_1810 {

    static boolean z = true;

    static U x1 = null;

    static V x2 = null;

    <T, U extends T, V extends T> T cond1(boolean z, U x1, V x2) {
        T t = z ? x1 : x2;
        return z ? x1 : x2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1810().cond1(z, x1, x2));
    }
}
