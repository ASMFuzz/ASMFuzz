public class MyJVMTest_128 {

    static int x = 0;

    int f(int x) {
        throw new Error();
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_128().f(x);
    }
}
