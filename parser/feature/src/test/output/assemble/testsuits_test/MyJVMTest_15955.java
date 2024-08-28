public class MyJVMTest_15955 {

    static int a = 1;

    int f1(int... a) {
        int[] b = a.clone();
        for (int i = 0; i < a.length; i++) if (a[i] != b[i])
            throw new Error("" + b[i]);
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15955().f1(a);
    }
}
