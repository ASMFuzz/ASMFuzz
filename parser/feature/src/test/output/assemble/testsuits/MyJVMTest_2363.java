public class MyJVMTest_2363 {

    static int a = 3;

    static int b = 8;

    static Integer i = 0;

    int equals(int a, int b) {
        if (a != b)
            throw new Error();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2363().equals(a, b);
    }
}
