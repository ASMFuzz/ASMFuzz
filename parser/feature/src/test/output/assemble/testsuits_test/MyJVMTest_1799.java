public class MyJVMTest_1799 {

    static boolean z = false;

    static U x1 = null;

    static V x2 = null;

    <T, U extends T, V extends T> T cond1(boolean z, U x1, V x2) {
        return (z ? (T) x1 : x2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1799().cond1(z, x1, x2));
    }
}
