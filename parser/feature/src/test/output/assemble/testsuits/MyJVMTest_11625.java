public class MyJVMTest_11625 {

    static int a = 7;

    static int b = 0;

    static Integer i = 0;

    int equals(int a, int b) {
        if (a != b)
            throw new Error();
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11625().equals(a, b);
    }
}
