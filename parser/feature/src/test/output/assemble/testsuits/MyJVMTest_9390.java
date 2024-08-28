public class MyJVMTest_9390 {

    static int a = 1021066202;

    static int b = 3;

    static T i = null;

    int equals(int a, int b) {
        if (a != b)
            throw new Error();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9390().equals(a, b);
    }
}
