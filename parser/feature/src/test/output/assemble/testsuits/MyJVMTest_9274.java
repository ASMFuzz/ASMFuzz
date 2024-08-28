public class MyJVMTest_9274 {

    static int x = 0;

    int f(int x) {
        throw new Error();
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9274().f(x);
    }
}
